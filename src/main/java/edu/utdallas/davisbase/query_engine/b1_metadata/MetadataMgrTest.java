package edu.utdallas.davisbase.query_engine.b1_metadata;


import edu.utdallas.davisbase.query_engine.a_server.SimpleDB;
import edu.utdallas.davisbase.storage_engine.e_record.Layout;
import edu.utdallas.davisbase.storage_engine.e_record.Schema;
import edu.utdallas.davisbase.storage_engine.f_tx.Transaction;

import static java.sql.Types.INTEGER;

public class MetadataMgrTest {
    public static void main(String[] args) {
        SimpleDB db = new SimpleDB("metadatamgrtest");
        Transaction tx = db.newTx();
        MetadataMgr mdm = new MetadataMgr(true, tx);

        // Create
        Schema sch = new Schema();
        sch.addIntField("A");
        sch.addStringField("B", 9);
        mdm.createTable("MyTable", sch, tx);

        // Read
        Layout layout = mdm.getLayout("MyTable", tx);
        int size = layout.slotSize();
        Schema sch2 = layout.schema();
        System.out.println("MyTable has slot size " + size);
        System.out.println("Its fields are:");
        for (String fldname : sch2.fields()) {
            String type;
            if (sch2.type(fldname) == INTEGER) type = "int";
            else {
                int strlen = sch2.length(fldname);
                type = "varchar(" + strlen + ")";
            }
            System.out.println(fldname + ": " + type);
        }


        tx.commit();
    }
}

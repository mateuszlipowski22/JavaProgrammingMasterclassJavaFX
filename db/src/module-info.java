module db {
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires common;
//    requires transitive common;

    exports db;
}
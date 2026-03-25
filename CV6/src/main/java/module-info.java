module cz.vsb.fei.java.lab06_module {
	requires java.sql;
	requires org.apache.logging.log4j;
	requires static lombok;
	requires jakarta.persistence;
    requires static jakarta.annotation;
	requires com.h2database;
	requires org.hibernate.orm.core;

	opens lab.data;

}

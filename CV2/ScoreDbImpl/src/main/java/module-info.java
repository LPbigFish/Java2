import me.filip.stegner.db.ScoreRepository;

module me.filip.stegner {
    exports me.filip.stegner.db;
    requires static lombok;
	requires org.apache.logging.log4j;
    requires java.sql;
    requires me.filip.stegner.api;
    requires com.h2database;
    provides me.filip.stegner.api.ScoreStorageInterface with ScoreRepository;
}
package ch.juventus.caesar.models.table;

public class TableFactory {
    private static TableFactory ourInstance = new TableFactory();

    public static TableFactory getInstance() {
        return ourInstance;
    }

    private TableFactory() {
    }

    public ITable createTable() {
        return new Table();
    }
}

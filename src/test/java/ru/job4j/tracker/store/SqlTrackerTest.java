package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream(
                "db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenAddThreeItemsThenFindAllReturnsAll() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("first"));
        tracker.add(new Item("second"));
        tracker.add(new Item("third"));
        List<Item> all = tracker.findAll();
        assertThat(all).hasSize(3);
    }

    @Test
    public void whenItemExistsThenFindByIdReturnsIt() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("findable");
        tracker.add(item);
        Item found = tracker.findById(item.getId());
        assertThat(found).isEqualTo(item);
    }

    @Test
    public void whenItemDoesNotExistThenFindByIdReturnsEmpty() {
        SqlTracker tracker = new SqlTracker(connection);
        Item found = tracker.findById(111);
        assertThat(found).isNull();
    }

    @Test
    public void whenReplaceExistingItemThenItIsUpdated() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("old name");
        tracker.add(item);

        Item updated = new Item("new name");
        boolean result = tracker.replace(item.getId(), updated);
        assertThat(result).isTrue();
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("new name");
    }

    @Test
    public void whenDeleteExistingItemThenItIsGone() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("to delete");
        tracker.add(item);

        tracker.delete(item.getId());
        Item result = tracker.findById(item.getId());
        assertThat(result).isNull();
    }

    @Test
    public void whenFindByNameThenReturnMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("first"));
        tracker.add(new Item("second"));
        tracker.add(new Item("first"));
        tracker.add(new Item("first"));
        List<Item> found = tracker.findByName("first");
        assertThat(found).hasSize(3);
    }
}
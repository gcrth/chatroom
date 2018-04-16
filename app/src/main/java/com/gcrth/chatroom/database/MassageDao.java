package com.gcrth.chatroom.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.gcrth.chatroom.entity.Massage;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MASSAGE".
*/
public class MassageDao extends AbstractDao<Massage, Long> {

    public static final String TABLENAME = "MASSAGE";

    /**
     * Properties of entity Massage.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property From = new Property(1, String.class, "from", false, "FROM");
        public final static Property To = new Property(2, String.class, "to", false, "TO");
        public final static Property Time = new Property(3, String.class, "time", false, "TIME");
        public final static Property Content = new Property(4, String.class, "content", false, "CONTENT");
    }


    public MassageDao(DaoConfig config) {
        super(config);
    }
    
    public MassageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MASSAGE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"FROM\" TEXT," + // 1: from
                "\"TO\" TEXT," + // 2: to
                "\"TIME\" TEXT," + // 3: time
                "\"CONTENT\" TEXT);"); // 4: content
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MASSAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Massage entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String from = entity.getFrom();
        if (from != null) {
            stmt.bindString(2, from);
        }
 
        String to = entity.getTo();
        if (to != null) {
            stmt.bindString(3, to);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Massage entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String from = entity.getFrom();
        if (from != null) {
            stmt.bindString(2, from);
        }
 
        String to = entity.getTo();
        if (to != null) {
            stmt.bindString(3, to);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Massage readEntity(Cursor cursor, int offset) {
        Massage entity = new Massage( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // from
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // to
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // time
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // content
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Massage entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setFrom(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTo(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContent(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Massage entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Massage entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Massage entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
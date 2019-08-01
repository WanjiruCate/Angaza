package com.shirucodes.angaza.database.databasecontacts;

import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract() {
    }


    public static class RECENT_VERIFICATION_ENTRY implements BaseColumns {

        public static final String TABLE_NAME = "recent_verifications";
        public static final String COLUMN_NAME_PARAGRAPH_STORY = "paragraph_story";
        public static final String COLUMN_NAME_VERIFICATION_DATE = "verification_date";
        public static final String COLUMN_NAME_ARTICLE_LINK = "article_link";
        public static final String COLUMN_NAME_PARAGRAPH_SCORE = "paragraph_score";
        public static final String COLUMN_NAME_PARAGRAPH_COMMENT = "paragraph_comment";
    }

    public static final String SQL_CREATE_RECENT_VERIFICATION_ENTRIES =
            "CREATE TABLE " + RECENT_VERIFICATION_ENTRY.TABLE_NAME + " (" +
                    RECENT_VERIFICATION_ENTRY.COLUMN_NAME_PARAGRAPH_STORY + " TEXT," +
                    RECENT_VERIFICATION_ENTRY.COLUMN_NAME_VERIFICATION_DATE + " TEXT ," +
                    RECENT_VERIFICATION_ENTRY.COLUMN_NAME_ARTICLE_LINK + " TEXT ," +
                    RECENT_VERIFICATION_ENTRY.COLUMN_NAME_PARAGRAPH_SCORE + " TEXT ," +
                    RECENT_VERIFICATION_ENTRY.COLUMN_NAME_PARAGRAPH_COMMENT + " TEXT )";


    public static final String SQL_DELETE_RECENT_VERIFICATION_ENTRIES =
            "DELETE * FROM " + RECENT_VERIFICATION_ENTRY.TABLE_NAME;


    public static final String SQL_DELETE_RECENT_VERIFICATION_TABLE =
            "DROP TABLE IF EXISTS " + RECENT_VERIFICATION_ENTRY.TABLE_NAME;

}

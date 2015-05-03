package com.medbrain.fuzzy.medbrain;

import android.provider.BaseColumns;

/**
 * Created by andres on 26/04/15.
 */
public final class MedDBContract {

    //constructor vacio
    public MedDBContract(){}
    public static final String TEXT_TYPE = " TEXT";

    public static abstract class MedicineContract implements BaseColumns{

        public static final String TABLE_NAME = "Medicines";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_TITLE = "Name";
        public static final String COLUMN_NAME_DOSE = "Dose";
        public static final String COLUMN_NAME_DETAILS = "Details";
    }

    public static abstract class PrescriptionContract implements BaseColumns{
        public static final String TABLE_NAME = "Prescriptions";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_DOCTOR ="Doctor";
        public static final String COLUMN_NAME_DATE = "Date";

    }

    public static abstract class MedPrescContract implements BaseColumns{
        public static final String TABLE_NAME = "MedPresc";
        public static final String COLUMN_NAME_PRESC_ID = "PrescID";
        public static final String COLUMN_NAME_MED_ID = "MedID";
    }

    public static abstract class UsersContract implements BaseColumns{
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_First_NAME = "First Name";
        public static final String COLUMN_NAME_SECOND_NAME = "Second Name";
        public static final String COLUMN_NAME_THIRD_NAME = "Third Name";
        public static final String COLUMN_NAME_BIRTH_DATE = "Birth Date";
        //public static final String COLUMN_NAME_PRESC_ID = "PrescID"; //una persona puede tener muchas presc
    }

}

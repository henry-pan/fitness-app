package fitness.cs115.a115fitnessapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by James Kennedy on 10/17/16.
 */

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class user_DBHelper_tests {
    private work_DBHelper user_work_db;
    private ArrayList<String> prog_list;
    private ArrayList<String> work_list;
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("fitness.cs115.a115fitnessapp", appContext.getPackageName());

        user_work_db = new work_DBHelper(appContext);

        System.out.println("starting work_DBHelper tests");
        user_work_db.clear_all_tables();

        user_work_db.dump_tables();

        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.create_program tests");

        user_work_db.create_program("testProgram 1");
        user_work_db.create_program("testProgram's 2");
        user_work_db.create_program("_test; Program\"s 3");

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.get_user_program_list test");

        prog_list = user_work_db.get_user_program_list();
        System.out.println("Program List: " + prog_list.toString() );

        user_work_db.dump_tables();
        System.out.println( "" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.create_workout tests");

        user_work_db.create_workout("Chest and Tri's");
        user_work_db.create_workout("Back;(and Biceps!)");
        user_work_db.create_workout("12_L3g_D4y_56");
        user_work_db.create_workout("Easy Day");
        user_work_db.create_workout("EXXTREEME");

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.add_work_to_prog tests");

        user_work_db.add_work_to_prog("testProgram 1", "Chest and Tri's");
        user_work_db.add_work_to_prog("testProgram 1", "Back;(and Biceps!)");
        user_work_db.add_work_to_prog("testProgram 1", "12_L3g_D4y_56");

        user_work_db.add_work_to_prog("testProgram's 2", "Easy Day");
        user_work_db.add_work_to_prog("testProgram's 2", "EXXTREEME");

        user_work_db.add_work_to_prog("_test; Program\"s 3","12_L3g_D4y_56");

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.get_workouts_from_prog test");

        //print workouts in each program using get_workouts_from_prog
        for (int i = 0; i < prog_list.size(); ++i) {
            work_list = user_work_db.get_workouts_from_prog(prog_list.get(i));
            System.out.println(prog_list.get(i) +": " + work_list.toString() );
        }



        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.add_exer_to_work tests");

        user_work_db.add_exer_to_work("Chest and Tri's", "Bench Press", "rep", 3, 10, 100);
        user_work_db.add_exer_to_work("Chest and Tri's", "Dumbell Press", "rep", 3, 10, 80);
        user_work_db.add_exer_to_work("Chest and Tri's", "Pushups", "rep", 4, 20, 0);
        user_work_db.add_exer_to_work("Chest and Tri's", "Dumbell Tricep Extension, Overhead",
                "rep", 4, 15, 50);

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);

        user_work_db.add_exer_to_work("Back;(and Biceps!)", "Pullups", "rep", 4, 10, 0);
        user_work_db.add_exer_to_work("Back;(and Biceps!)", "Dumbell Curls", "rep", 4, 10, 30);
        user_work_db.add_exer_to_work("Back;(and Biceps!)", "Planks", "timed", 4, 60, 0);

        user_work_db.add_exer_to_work("12_L3g_D4y_56", "Squats", "rep", 4, 10, 60);
        user_work_db.add_exer_to_work("12_L3g_D4y_56", "Lunges", "rep", 4, 10, 30);
        user_work_db.add_exer_to_work("12_L3g_D4y_56", "Planks", "rep", 4, 60, 0);
        user_work_db.add_exer_to_work("12_L3g_D4y_56", "Run a mile", "timed", 1, 10, 0);

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.create_session tests");

        int sess_id = user_work_db.create_session("Chest and Tri's");

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("starting work_DBHelper.create_work_log tests");

        //TODO: test user_work_db.create_work_log(sess_id);

        user_work_db.dump_tables();
        System.out.println("" + new Exception().getStackTrace()[0]);
        System.out.println("finished work_DBHelper tests");
    }

    
}
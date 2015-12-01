package com.example.nnnnew.dailycost;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    public int day;
    private String month;
    private int monthNumber;
    private int years;
    String[] str = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final LinearLayout btnDay = (LinearLayout)findViewById(R.id.linear_day);
        final LinearLayout btnMonth = (LinearLayout)findViewById(R.id.linear_month);
        final LinearLayout btnYear = (LinearLayout)findViewById(R.id.linear_year);
        final TextView textday = (TextView)findViewById(R.id.text_day);
        final TextView textmonth = (TextView)findViewById(R.id.text_month);
        final TextView textyear = (TextView)findViewById(R.id.text_year);
        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDay.setBackgroundColor(Color.parseColor("#7ba6a3"));
                btnMonth.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnYear.setBackgroundColor(Color.parseColor("#e9fff8"));
                textday.setTextColor(Color.parseColor("#fff3db"));
                textmonth.setTextColor(Color.parseColor("#009688"));
                textyear.setTextColor(Color.parseColor("#009688"));
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SummaryActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Log.i("DateChekk", years + "/" + month + "/" + day);
                        years = year;
                        monthNumber = monthOfYear;
                        day = dayOfMonth;
                        month = str[monthOfYear];
                        setDateText();
                    }
                }, years, monthNumber, day);
                datePickerDialog.show();
            }
        });
        btnMonth.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDay.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnMonth.setBackgroundColor(Color.parseColor("#7ba6a3"));
                btnYear.setBackgroundColor(Color.parseColor("#e9fff8"));
                textday.setTextColor(Color.parseColor("#009688"));
                textmonth.setTextColor(Color.parseColor("#fff3db"));
                textyear.setTextColor(Color.parseColor("#009688"));
            }
        }));
        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDay.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnMonth.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnYear.setBackgroundColor(Color.parseColor("#7ba6a3"));
                textday.setTextColor(Color.parseColor("#009688"));
                textmonth.setTextColor(Color.parseColor("#009688"));
                textyear.setTextColor(Color.parseColor("#fff3db"));

            }
        });


    }

    private void setDateText() {
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int tmpYear = today.year;
        int tmpMonth = today.month;
        int tmpDay = today.monthDay;

        TextView dateTV = (TextView) findViewById(R.id.data_textview);
        if (day == tmpDay && monthNumber == tmpMonth && years == tmpYear) {
            dateTV.setText("TODAY");
        }
        else {
            dateTV.setText(day + "/" + month + "/" + years);
        }
    }
}

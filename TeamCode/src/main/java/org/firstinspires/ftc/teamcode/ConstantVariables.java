package org.firstinspires.ftc.teamcode;
// Created for 16887
public class ConstantVariables {
    public static final int    K_PPR_DRIVE = 385;      // Number of ticks per revolution (AndyMark) 1120
    public static final double K_DRIVE_WHEEL_DIA = 4; // Diameter of the mecanum wheel in inches (4)
    public static final double K_DRIVE_DIA = 16.5;      // Diameter?

    public static final double K_DRIVE_WHEEL_CIRCUMFERENCE = K_DRIVE_WHEEL_DIA * Math.PI;// 12.6 inch
    public static final double K_PPIN_DRIVE = K_PPR_DRIVE / K_DRIVE_WHEEL_CIRCUMFERENCE; // 89.1 ticks/inch

    public static final double K_TURN_CIRCUMFERENCE = K_DRIVE_DIA * Math.PI;  // Circumference
    public static final double K_PPTURN_DRIVE = K_PPIN_DRIVE * K_TURN_CIRCUMFERENCE;
    public static final double K_PPDEG_DRIVE = K_PPTURN_DRIVE / 360;     // in degrees
    public static final double K_DRIVE_ERROR_P = 250; // higher = less sensitive

    // At the beginning, LIFT is down.  At START, LIFT is set to UP.
    public static final int    K_LIFT_DOWN = 5;       // Down position for Lift1
    public static final int    K_LIFT_UP = 90;       // Up position for Lift1
    public static final int    K_LIFT_ONE_REV = 270;  // one rev in encode ticks?
    public static final int    K_LIFT_DOWN_FOUND =  5;  // Down position in foundation, in ticks
    public static final int    K_LIFT_UP_FOUND   = 400; // Up position in foundation, in ticks
    public static final int    K_LIFT_ERROR = 15;       // Tolerance due to bad lift motor
    public static final double K_LIFT_NUM_REV_PER_STEP = 3.0; // Number of revolution for each step
    public static final double K_LIFT_MAX_PWR = 1.0; // Maximum power (speed) to target position


    public static final double K_LEFT_SERVO_OPEN = 0.3;     // STEP
    public static final double K_LEFT_SERVO_CLOSE = 0.8;

    public static final double K_RIGHT_SERVO_OPEN = 0.16;     // STEP
    public static final double K_RIGHT_SERVO_CLOSE = 0.7;   // Back is set to run in REVERSE?

    // Since the four motors are not identical, an additional factor is used to adjust the speed
    // so that they will run equally.
    // Since the power is below -1.0 and 1.0, these factors should be less than one to avoid
    // clipping
    public static final double K_LF_ADJUST = 1.0;
    public static final double K_LB_ADJUST = 1.0;
    public static final double K_RF_ADJUST = 1.0;
    public static final double K_RB_ADJUST = 1.0;
    // Multiplication factor for Angularity Velocity - ticks per second
    public static final double K_Ang_Rate_ADJUST = K_PPR_DRIVE * 2.0; // One revolution per sec?
    public static final byte   PIXY_INITIAL_ARRAYSIZE = 0;
    public static final short PIXY_MAXIMUM_ARRAYSIZE = 130;
    public static final int PIXY_START_WORD = 0xaa55; //for regular color recognition
    public static final int PIXY_START_WORD_CC = 0xaa56; //for color code - angle rotation recognition
    public static final int PIXY_START_WORDX = 0x55aa; //regular color another way around
    public static final byte PIXY_MAX_SIGNATURE = 7;
    public static final int PIXY_DEFAULT_ARGVAL = 0xffff;

    // Pixy x-y position values
    public static final long PIXY_MIN_X = 0L;   //x: 0~255 pixels, y:0~199 pixels. (0,0) starts at bottom left
    public static final long PIXY_MAX_X = 255L;
    public static final long PIXY_MIN_Y = 0L;
    public static final long PIXY_MAX_Y = 199L;
}
// Andy Mark Motor Specification
// Ticks Per Revolution or PPR (Pulse Per Revolution): 1120

// Maximum speed: 128 revolution per minute? 2 revolution per second
// PPR = Pulse Per Revolution = 1,120
// PPIN = Pulse Per INch = PPR / Circumference of the wheel = 1,120 (Pi * Diameter)
// PPDEG = Pulse Per DEGree = PPR / 360
// PPTURN = Pulse Per Turn =

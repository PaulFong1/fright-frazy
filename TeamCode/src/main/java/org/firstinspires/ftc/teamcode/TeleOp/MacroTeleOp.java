package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.BaseRobot;

// Created for 16887.
@TeleOp(name = "Macro TeleOp", group = "TeleOp")
//@Disabled
public class MacroTeleOp extends BaseRobot {
    private int stage = 0;
    private int firstLevel = 0;
    private int secondLevel = 200;
    private int thirdLevel = 800;
    private int rot1holdpos = 0;   // The target position for the rotate
    // actuator may oscillate around this value
    // Encoder values are not very accurate
    //  private boolean turned = false;

    @Override
    public void init() {

        super.init();
    }

    @Override
    public void start() {
        super.start();
        // axle_spin.resetDeviceConfigurationForOpMode();
/*
        actuator.setTargetPosition(100);
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        actuator.setPower(0);
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

 */





        //    rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void loop() {

        //  telemetry.addData("actuator:", "pos=%d, power=%.2f, zero=%s, tar=%d", actuator.getCurrentPosition(), actuator.getPower(), actuator.getZeroPowerBehavior(), actuator.getTargetPosition());
        //     reset_drive_encoders();
        //    reset_linearSlide_encoders();
        //    reset_rotate_encoders();
        //     reset_spin_encoders();
        //tankanum_original(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);

        telemetry.addData("your", "mom");

        if (gamepad2.left_bumper)
        {
            box_Spin.setPosition(0.5);
        }
        else if (gamepad2.right_bumper)
        {
            box_Spin.setPosition(-0.5);
        }

        else {
            topSpin.setPower(0);
        }

        if (gamepad2.left_trigger > 0.2)
            topSpin.setPower(gamepad1.left_trigger);

        else if (gamepad2.right_trigger>0.2)
            topSpin.setPower(-1*gamepad1.right_trigger);
        else topSpin.setPower(0);
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //    rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Mini movements
        //    if ((gamepad1.right_stick_y == 0) && (gamepad1.left_stick_y == 0) && (gamepad1.right_stick_x == 0)) {
        //          if (gamepad1.dpad_up) auto_drive(0.75, 0.5);
        //       else if (gamepad1.dpad_down) auto_drive(-0.75, 0.5);


        //     }






        if (gamepad1.a)
            axle_Spin.setPower(1.0);
        else if (gamepad1.b)
            axle_Spin.setPower(-1.0);
        else
            axle_Spin.setPower(0);




//        telemetry.addData("lift enc: ", "=%.2f", linearSlide.getCurrentPosition());
//        telemetry.addData("stage: ", "=%d",stage);
        telemetry.update();




        //turn the motor for the linear slide
//        if (gamepad1.a) linearSlide.setPower(1.0); //extend
//        else if (gamepad1.b) linearSlide.setPower(-1.0); //retract
//
//        else if (gamepad1.x) {
//            if (stage < 2 && get_linearSlide_motor_enc() < 510) {
//                stage++;
//                linearSlideSetPosition(linearSlide, stage, 0.3);
//            }
//        } else if (gamepad1.y) {
//            if (stage > 0 && get_linearSlide_motor_enc() > 490) {
//                stage--;
//                linearSlideSetPosition(linearSlide, stage, 0.3);
//            }
//
//        } else linearSlide.setPower(0);



        if (gamepad1.dpad_up) {
            actuator.setTargetPosition(100);
            actuator.setPower(0.5);
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            box_Spin.setPosition(0.5);
            box_Spin.setPosition(0);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            actuator.setTargetPosition(0);
            actuator.setPower(-0.5);
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        else if (gamepad1.dpad_down) {
            actuator.setTargetPosition(0);
            actuator.setPower(-0.5);
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//            while (actuator.isBusy()) { }
            // rotate2.setPower(0.5);

            // else if (get_actuator_motor_enc()>=200)
            //     actuator.setPower(-0.4);
            // else if (get_actuator_motor_enc()>=100)
            //      actuator.setPower(-0.3);
        }

        else {
            actuator.setTargetPosition(actuator.getCurrentPosition());        // Try to stabilize
            actuator.setPower(-1.0);                        // Need maximize the hold the position
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            while (actuator.isBusy()) { }
            //    actuator.setPower(0.0);
            //     actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


            //  rotate2.setPower(0.0);

            //rotate2.setPower(0.05);
            //     rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        }




        if (gamepad1.left_stick_button) DEBUG = !DEBUG; // Toggle the debug flag
        super.loop();



    }

}


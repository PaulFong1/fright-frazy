package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.BaseRobot;

// Created for 16887.
@TeleOp(name = "TwoDriversTeleOp", group = "TeleOp")
//@Disabled
public class TwoDriversTeleOp extends BaseRobot {
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

        actuator.setTargetPosition(100);
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        actuator.setPower(0);
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);





    //    rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void loop() {
        super.loop();

        if (gamepad2.a)
            axle_Spin.setPower(1.0);
        else if (gamepad2.b)
            axle_Spin.setPower(-1.0);
        else
            axle_Spin.setPower(0);

        telemetry.addData("actuator:", "pos=%d, power=%.2f, zero=%s, tar=%d", actuator.getCurrentPosition(), actuator.getPower(), actuator.getZeroPowerBehavior(), actuator.getTargetPosition());
        //     reset_drive_encoders();
        //    reset_linearSlide_encoders();
        //    reset_rotate_encoders();
        //     reset_spin_encoders();
        //        tankanum_original(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        // tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);

        //tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        tankanum_original(-0.7 * gamepad1.right_stick_y, -0.7 * gamepad1.left_stick_y, -0.7 * gamepad1.right_stick_x);
        //  tank_drive(gamepad1.left_stick_y, gamepad1.right_stick_y);
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //    rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Mini movements
        //    if ((gamepad1.right_stick_y == 0) && (gamepad1.left_stick_y == 0) && (gamepad1.right_stick_x == 0)) {
        //          if (gamepad1.dpad_up) auto_drive(0.75, 0.5);
        //       else if (gamepad1.dpad_down) auto_drive(-0.75, 0.5);


        //     }

        if (gamepad2.left_bumper)
            box_Spin.setPosition(0.4);

        if (gamepad2.right_bumper)
            box_Spin.setPosition(0.1);


        if (get_linearSlide_motor_enc() < secondLevel - 100) stage = 0;
        else if (get_linearSlide_motor_enc() < thirdLevel - 100) stage = 1;
        else stage = 2;

//        telemetry.addData("lift enc: ", "=%.2f", linearSlide.getCurrentPosition());
//        telemetry.addData("stage: ", "=%d",stage);
        telemetry.update();

        // if (gamepad2.x && stage < 2) {
        //   linearSlideSetPosition(linearSlide, stage == 0 ? secondLevel : thirdLevel);
        // stage++;
        //}

        //else if (gamepad2.y && stage > 0) {
        //  linearSlideSetPosition(linearSlide, stage == 2 ? secondLevel : firstLevel);
        // stage--;
        //}

        if (gamepad2.dpad_right) {
            linearSlide.setPower(0.85);
            if (linearSlide.getCurrentPosition() >= secondLevel) {
                stage = 1;
            }
            if (linearSlide.getCurrentPosition() >= thirdLevel) {
                stage = 2;
            }
        } else if (gamepad2.dpad_left) {
            linearSlide.setPower(-0.4);
            if (linearSlide.getCurrentPosition() <= secondLevel) {
                stage = 1;
            }
            if (linearSlide.getCurrentPosition() <= firstLevel) {
                stage = 0;
            }
        } else linearSlide.setPower(0);

        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //turn the motor for the linear slide
//        if (gamepad1.a) linearSlide.setPower(1.0); //extend
//        else if (gamepad1.b) linearSlide.setPower(-1.0); //retract
//
//       =

//
//        } else linearSlide.setPower(0);

        if (gamepad1.x)
        {
            // sets actuator to zero, sets linear slide position to 0
                actuator.setTargetPosition(0);
                linearSlideSetPosition(linearSlide, 0);

        } else if (gamepad1.y)
          {

              // sets actuator to 3rd tier position, sets linear slide to 3rd stage
              actuator.setTargetPosition(100);
              linearSlideSetPosition(linearSlide, 900);



          }

        if (gamepad1.left_bumper)
            topSpin.setPower(0.5);

        else if (gamepad1.right_bumper)
            topSpin.setPower(-0.5);
        else topSpin.setPower(0);


        if (gamepad2.dpad_up) {
// Don't know if RUN_TO_POSITION is better than BRAKE
//            actuator.setPower(-1);
//            rot1holdpos = actuator.getCurrentPosition() - 1;  // Each press move the rotate up 10 pos
            rot1holdpos -= 250;  // Each press move the rotate up 10 pos
            actuator.setTargetPosition(rot1holdpos);
            actuator.setPower(-1.0);                           // maximum power to move up and hold
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while (actuator.isBusy()) { }        // May cause loop problem
            //rotate2.setPower(0.1);

       //     actuator.setPower(-1.0);
        }
         else if (gamepad2.dpad_down) {
//            actuator.setPower(0.3);
//            rot1holdpos = actuator.getCurrentPosition() + 1;
            rot1holdpos += 25;
            actuator.setTargetPosition(rot1holdpos);
            actuator.setPower(0.7);
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            while (actuator.isBusy()) { }
            // rotate2.setPower(0.5);
//actuator.setPower(1.0);
            // else if (get_actuator_motor_enc()>=200)
            //     actuator.setPower(-0.4);
            // else if (get_actuator_motor_enc()>=100)
            //      actuator.setPower(-0.3);
        }

        else {
            actuator.setTargetPosition(rot1holdpos);        // Try to stabilize
           actuator.setPower(-1.0);                        // Need maximize the hold the position
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //    actuator.setPower(0);
            actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            while (actuator.isBusy()) { }
        //    actuator.setPower(0.0);
            //     actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


         //  rotate2.setPower(0.0);

            //rotate2.setPower(0.05);
       //     rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        }


            if (gamepad1.left_stick_button) DEBUG = !DEBUG; // Toggle the debug flag



        }

    }


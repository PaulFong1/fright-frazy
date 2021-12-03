package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created  for 16887.
@Autonomous(name="BlueDuck", group="Simple")
//@Disabled
public class BlueDuck extends BaseRobot {
    private int step = 0;

    @Override
    public void init() {
        super.init();
        DEBUG = true;
    }

    @Override
    public void start() {
        super.start();
//        lift1.setPower(0.0);            // Don't need LIFT for this mode
//        lift1.setTargetPosition(0);
    }

    @Override
    public void loop() {
        switch (step) {
            case 0:
                auto_mecanum(-0.3, 10);
                step++;
                break;
            case 1:
                try {
                    topSpin.setPower(0.7);

                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }



                step++;
                break;
            case 2:
                topSpin.setPower(0);
                auto_mecanum(-0.3, 50);
                step++;
                break;
            case 3:
                auto_drive(-0.5, 5);
                step++;
                break;
            case 4:
                auto_mecanum(-0.5, 25);
                // step++;
                break;

            default: break;
        }
        /*
        if (time<1)
        {
            auto_turn(0.5,-10);
        }
        else if (time>1&&time<2) {
            tank_drive(0.4,0.4);
            //      auto_drive(-0.3, 5);
         //   rotate1.setPower(-0.3);
        }
        else if (time<4.0 && time>2.5)
            auto_turn(0.5,45);
        else if (time>5.1 && time <5.6) {

            tank_drive(0.3,0.3);

          //  rotate1.setPower(-0.5);
        }
        else if (time>5.7 && time <7.5)
        {
            topSpin.setPower(0.5);
        }


        else if (time<8.5 && time > 7.5)
        {
            topSpin.setPower(0);
            tank_drive(-0.2,-0.2);
        }
        else if (time<10 && time > 7.2) {
            auto_turn(-0.5,-20);



        }

         */
       // else if (time<8 && time > 7)
         //   rotate1.setPower(-0.8);
/*
        else if (time<12 && time > 10) {

            tank_drive(-0.5,-0.5);
        }
        else if (time<14 && time > 12) {

            auto_turn(0.5,5);
        }
        else if (time<17 && time > 14) {

            tank_drive(-0.5,-0.5);
        }
        //
        // else if (time<17 && time>10)
        //       auto_drive(0.5,25);


        else
        {

            tank_drive(0,0);
            topSpin.setPower(0);
            return;

        }

 */
        if (DEBUG) {
            telemetry.addData("step", "=%d",step);

            telemetry.addData("Front curr pos:", "Left=%d, Right=%d", get_leftFront_motor_enc(), get_rightFront_motor_enc());
            telemetry.addData("Back  curr pos:", "Left=%d, Right=%d", get_leftBack_motor_enc(), get_rightBack_motor_enc());
            telemetry.addData("Front power: ", "Left=%.2f, Right=%.2f", leftFront.getPower(), rightFront.getPower());
            telemetry.addData("Back  power: ", "Left=%.2f, Right=%.2f", leftBack.getPower(), rightBack.getPower());
            telemetry.addData("linearSlide:", "pos=%d, power=%.2f", get_linearSlide_motor_enc(), linearSlide.getPower());
            //telemetry.addData("topSpin:", "pos=%d, power=%.2f", get_topSpin_motor_enc(), topSpin.getPower());
            telemetry.addData("rotate1:", "pos=%d, power=%.2f", get_rotate1_motor_enc(), rotate1.getPower());
        }
    }
}

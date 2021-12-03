package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
// Created  for 16887.
@Autonomous(name="RedDuckBlock", group="Simple")
//@Disabled
public class RedDuck extends BaseRobot {
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
        /*
        if (time<2.25) {
            tank_drive(0.3,0.3);
      //      auto_drive(-0.3, 5);
         //   rotate1.setPower(-0.3);
        }
        else if (time<5.2 && time>3.0) {
            topSpin.setPower(-0.5);
          //  rotate1.setPower(-0.5);
        }

        else if (time>5.3 && time <6.4)
        {
            tank_drive(-0.3,-0.3);
        }
        else if (time<7.4 && time > 6.4) {
            auto_turn(-0.4,12);



        }

      // else if (time<8.4 && time > 7.4){}
//            rotate1.setPower(-0.8);

        else if (time<13 && time > 9.5) {

            tank_drive(-0.5,-0.5);
        }
    //
       // else if (time<17 && time>10)
     //       auto_drive(0.5,25);
        else
        {

            tank_drive(0,0);
           // topSpin.setPower(0);
            return;

        }

         */
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
                auto_mecanum(-0.3, 30);
                step++;
                break;
           case 3:
                 auto_drive(0.5, 5);
                step++;
                break;
            case 4:
                try {
                    axle_Spin.setPower(0.7);

                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                step++;
                break;
            case 5:
                axle_Spin.setPower(0);
                auto_drive(-0.5,5);
                step++;
                break;
            case 6:
                auto_mecanum(-0.5, 25);
               // step++;
                break;

            default: break;
        }


        if (DEBUG) {
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

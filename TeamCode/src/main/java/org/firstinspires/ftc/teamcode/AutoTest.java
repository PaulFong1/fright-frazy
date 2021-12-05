package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

// Created  for 16887.
@Autonomous(name="auto Test", group="Simple")
//@Disabled
public class AutoTest extends BaseRobot {
    private int stage = 0;

    @Override
    public void init() {
        super.init();
        DEBUG = true;

    }
    @Override
    public void start() {
        super.start();
    }
    @Override
    public void loop() {
   axle_Spin.setPower(0.7);
        // auto_mecanum(0.7,20);
   //     auto_drive(0.7,50);
     //   if (time<10)
      //      axle_Spin.setPower(-0.7);
       // else
       // axle_Spin.setPower(0);
    // auto_spin(axle_Spin,0.7,3);
    //    auto_mecanum(0.7,50);
      //  topSpin.setPower(0.5);
       //auto_turn(0.5,15);
     //   String debug = "here";
      //  telemetry.addData("debug","=%s",debug);
//        auto_drive(0.5,15);

     /*   switch (stage) {
            case 0: auto_turn(0.5, 45);
              stage++;
              break;
            case 1: auto_turn(-0.5, 45);
                stage++;
                break;
            case 2: auto_turn(0.5, 90);
                stage++;
                break;
            case 3: auto_turn(-0.5, 90);
                stage++;
                break;
//            case 1: auto_drive(0.5, 1);
//              break;
            default: break;
        }

      */
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

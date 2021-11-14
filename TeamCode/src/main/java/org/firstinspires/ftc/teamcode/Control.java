package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

public class Control {

    public static class pid {
        private ElapsedTime runtime;
        private double oldError;
        private double oldIntegral;
        private double oldTime;

        private double integralReset;

        public pid(double integralResetThreshold) {
            runtime = new ElapsedTime();
            oldError = 0;
            oldIntegral = 0;
            oldTime = 0;
            integralReset = integralResetThreshold;
        }

        public double getPower(double goalPosition, double currentPosition, double p, double i, double d) {

            double integral;
            double derivative;


            double error = goalPosition-currentPosition;
            double dT = runtime.milliseconds()-oldTime;

            if(Math.abs(error)>integralReset)
                oldIntegral = 0;

            integral = oldIntegral + error * dT;
            derivative = (error-oldError);

            oldError = error;
            oldIntegral = integral;
            oldTime = runtime.milliseconds();

            return p*error + i*integral + d*derivative;
        }
    }
}

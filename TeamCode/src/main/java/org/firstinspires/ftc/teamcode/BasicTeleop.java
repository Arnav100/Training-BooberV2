package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Basic teleop")
public class BasicTeleop extends OpMode {

    private DcMotor lfDrive, rfDrive, lmDrive, lbDrive, rmDrive, rbDrive;
    private Servo armServo;
    private DcMotor leftGripper, rightGripper;

    @Override
    public void init() {
        //We gain acces to the following instance vairable:
        // hardwareMap -- used for getting motors and sensor objects
        // telemetry -- used for output to the driver station phone
        // gamepad1 and gamepad2 -- used to control robot
        lfDrive = hardwareMap.get(DcMotor.class, "LeftFrontDrive");
        lmDrive = hardwareMap.get(DcMotor.class, "LeftMiddleDrive");
        lbDrive = hardwareMap.get(DcMotor.class, "LeftBackDrive");
        rfDrive = hardwareMap.get(DcMotor.class, "RightFrontDrive");
        rmDrive = hardwareMap.get(DcMotor.class, "RightMiddleDrive");
        rbDrive = hardwareMap.get(DcMotor.class, "RightBackDrive");

        armServo = hardwareMap.get(Servo.class, "ArmServo");

        leftGripper = hardwareMap.get(DcMotor.class, "LeftIntake");
        rightGripper = hardwareMap.get(DcMotor.class, "RightIntake");

        lmDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        /* First you have to check each indiviual motor
         * Check correct motor is moving
         * Check motor is moving in correct direction
         * */

     //   lmDrive.setPower(0.3);

        double rightPower = gamepad1.right_stick_y;
        double leftPower = gamepad1.left_stick_y;

        lfDrive.setPower(leftPower);
        lmDrive.setPower(leftPower);
        lbDrive.setPower(leftPower);

        rfDrive.setPower(rightPower);
        rmDrive.setPower(rightPower);
        rbDrive.setPower(rightPower);

        if(gamepad1.dpad_up) {
            armServo.setPosition(0.5);
        }
        else if (gamepad1.dpad_down) {
            armServo.setPosition(0);
        }

        if(gamepad1.a){
            leftGripper.setPower(0.5);
            rightGripper.setPower(-0.5);
        }
        else if(gamepad1.b) {
            leftGripper.setPower(-0.5);
            rightGripper.setPower(0.5);
        }
        else {
            leftGripper.setPower(0);
            rightGripper.setPower(0);
        }

    }

    @Override
    public void stop() {
        lfDrive.setPower(0);
        lmDrive.setPower(0);
        lbDrive.setPower(0);

        rfDrive.setPower(0);
        rmDrive.setPower(0);
        rbDrive.setPower(0);


    }
}

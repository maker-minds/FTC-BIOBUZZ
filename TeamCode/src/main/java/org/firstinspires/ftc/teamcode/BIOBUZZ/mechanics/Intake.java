package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.BIOBUZZ.opModes.OpModeAgents;

public class Intake {

    //---Objects---\\
    private CRServo intake = null;
    private CRServo threadmill = null;
    private DistanceSensor gate = null;

    //---Variables---\\
    private boolean lastScan = false;

    //---Functions---\\

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(CRServo.class, "intake");
        threadmill = hardwareMap.get(CRServo.class, "threadmill");
        gate = hardwareMap.get(DistanceSensor.class, "gate");
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        threadmill.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void activate() {
        intake.setPower(1);
    }

    public void deactivate() {
        intake.setPower(0);
    }

    public void scan() {
        double distance = gate.getDistance(DistanceUnit.MM);
        if (distance > 65) {
            lastScan = false;
            return;
        }
        if (!lastScan) {
            OpModeAgents.storedItems++;
            lastScan = true;
        }
        if(OpModeAgents.storedItems == 4) {
            deactivate();
        }
    }
}

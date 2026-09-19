package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Limelight {

    private Limelight3A limelight;
    LLResult llresult;

    public Limelight(HardwareMap hardwareMap) {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);
    }

    public void start() {
        limelight.start();
    }

    public double[] getResult() {
        llresult = limelight.getLatestResult();
        double[] results = new double[3];
        if(llresult != null & llresult.isValid()) {
            results[0] = llresult.getTx();
            results[1] = llresult.getTy();
            results[2] = llresult.getTa();
        }
        return results;
    }
}

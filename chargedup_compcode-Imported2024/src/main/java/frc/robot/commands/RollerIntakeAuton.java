package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RollerIntake;

public class RollerIntakeAuton extends Command {
    RollerIntake mIntake;
    Timer timer = new Timer();
    final double mTime;
    double mSpeed;

    public RollerIntakeAuton(RollerIntake pIntake, double pSpeed, double pTime){
        mIntake = pIntake;
        mTime = pTime;
        mSpeed = pSpeed;
        addRequirements(mIntake);
    }

    @Override
    public void initialize(){
        timer.reset(); // resets timer and starts it
        timer.start();
    }

    @Override
    public void execute(){ // moves the intake
        mIntake.moveSpeed(mSpeed);
    }

    @Override
    public void end(boolean interrupted){ // takes in a true or false variable if the auton is "interrupted" or not
        timer.stop(); // if true, stops the time and stops the intake from moving
        mIntake.moveSpeed(0);
    }

    @Override
    public boolean isFinished(){
        return mTime < timer.get(); // when the accumplated time is greater than the time
                                    // needed for the auton, returns true (returns true when auton is finished)
    }
}
    

 
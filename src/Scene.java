// <editor-fold defaultstate="collapsed" desc="imports">

import javax.swing.JOptionPane;
import org.lgna.story.*;
import org.lgna.story.resources.prop.CastleWallResource;
import org.lgna.story.resources.biped.PlayingCardResource;
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.SGround.SurfaceAppearance;
// </editor-fold>

class Scene extends SScene {

    /* Construct new Scene */
    public Scene() {
        super();
    }

    /* Event listeners */
    private void initializeEventListeners() {
        this.addSceneActivationListener((SceneActivationEvent event) -> {
            this.myFirstMethod();
        });
    }

    /* Procedures and functions for this scene */
    public void myFirstMethod() {
        // Card Game created by Noah Miller
// 12/14/2019
// This program will deal out cards, display winner, and then cards disappear
// initialize variables
        introduction();
        for (int a = 1; a <= 5; a++) {
            dealCards();
            if (randomNumber1 > randomNumber2) {
                player1Wins();
            } else {
                player2Wins();
            }//end if 
            dissappearCards();
        }//ends games loop

    }//end   my first method

    public void introduction()

    {

        String name1 = JOptionPane.showInputDialog(null, "please type in the name of the first player");
        player1.setValue(name1);

        String name2 = JOptionPane.showInputDialog(null, "please type in the name of the second player");
        player2.setValue(name2);
    }

    public void dealCards()

    {
// deal out cards

        randomNumber1 = (int) (Math.random() * 10);
        randomNumber2 = (int) (Math.random() * 10);
        do {
            randomNumber1 = (int) (Math.random() * 10);
            randomNumber2 = (int) (Math.random() * 10);
        } while (randomNumber1 == randomNumber2);
        firstCard = cardArray[randomNumber1];
        secondCard = cardArray[randomNumber2];

        this.castleWall2.say("Deal out the cards please !", Say.duration(3.0));
        firstCard.moveTo(this.cone1);
        secondCard.moveTo(this.cone2);

    }

    public void player1Wins()

    {
        for (int x = 1; x <= 3; x++) {
            win1sign.setOpacity(1.0, SetOpacity.duration(1.0));
            win1sign.setOpacity(0.0, SetOpacity.duration(1.0));

        }//ends loop 
        score1++;
        this.p1ScoreSign.setValue("Score : " + score1);
    }

    public void player2Wins()

    {
        for (int x = 1; x <= 3; x++) {
            win2sign.setOpacity(1.0, SetOpacity.duration(1.0));
            win2sign.setOpacity(0.0, SetOpacity.duration(1.0));

        }//ends loop 
        score2++;
        this.p2ScoreSign.setValue("Score : " + score2);
    }

    public void dissappearCards()

    {
        firstCard.turn(TurnDirection.LEFT, 8.0);
        firstCard.moveTo(this.coneOutside);
        secondCard.turn(TurnDirection.LEFT, 8.0);
        secondCard.moveTo(this.coneOutside);
        this.ground.delay(4.0);
    }

    
    

    
    
    

 
        /* End procedures and functions for this scene */
        // <editor-fold defaultstate="collapsed" desc="/* Scene fields  */">
    private final SGround ground = new SGround();
    private final SCamera camera = new SCamera();
    private final CastleWall castleWall2 = new CastleWall(CastleWallResource.DEFAULT);
    private final TextModel player1 = new TextModel();
    private final CastleWall castleWall = new CastleWall(CastleWallResource.DEFAULT);
    private final TextModel player2 = new TextModel();
    private final TextModel win1sign = new TextModel();
    private final TextModel win2sign = new TextModel();
    private final TextModel p1ScoreSign = new TextModel();
    private final TextModel p2ScoreSign = new TextModel();
    private final Cone cone1 = new Cone();
    private final Cone cone2 = new Cone();
    private final SCameraMarker originalCamera = new SCameraMarker();
    private final Cone coneOutside = new Cone();
    private final PlayingCard playingCard1 = new PlayingCard(PlayingCardResource.ONE1);
    private final PlayingCard playingCard2 = new PlayingCard(PlayingCardResource.TWO2);
    private final PlayingCard playingCard3 = new PlayingCard(PlayingCardResource.THREE3);
    private final PlayingCard playingCard4 = new PlayingCard(PlayingCardResource.FOUR4);
    private final PlayingCard playingCard5 = new PlayingCard(PlayingCardResource.FIVE5);
    private final PlayingCard playingCard6 = new PlayingCard(PlayingCardResource.SIX6);
    private final PlayingCard playingCard7 = new PlayingCard(PlayingCardResource.SEVEN7);
    private final PlayingCard playingCard8 = new PlayingCard(PlayingCardResource.EIGHT8);
    private final PlayingCard playingCard9 = new PlayingCard(PlayingCardResource.NINE9);
    private final PlayingCard playingCard10 = new PlayingCard(PlayingCardResource.TEN10);
    private final TextModel creatorName = new TextModel();
    int score1 = 0;
    int score2 = 0;
    int randomNumber1, randomNumber2;
    PlayingCard firstCard, secondCard;
    PlayingCard cardArray[] = {playingCard1, playingCard2, playingCard3, playingCard4, playingCard5,
        playingCard6, playingCard7, playingCard8, playingCard9, playingCard10};

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="/* Scene setup  */">
    private void performCustomSetup() {
// Make adjustments to the starting scene, in a way not available in the Scene editor
    }

    private void performGeneratedSetUp() {
// DO NOT EDIT
// This code is automatically generated.  Any work you perform in this method will be overwritten.
// DO NOT EDIT
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.ground.setPaint(SurfaceAppearance.GRASS);
        this.ground.setOpacity(1.0);
        this.ground.setName("ground");
        this.ground.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(-0.00116667, 0.993507, 0.113301, 0.0102302));
        this.camera.setPositionRelativeToVehicle(new Position(0.385, 2.0, -9.26));
        this.castleWall2.setPaint(Color.WHITE);
        this.castleWall2.setOpacity(1.0);
        this.castleWall2.setName("castleWall2");
        this.castleWall2.setVehicle(this);
        this.castleWall2.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.castleWall2.setPositionRelativeToVehicle(new Position(5.2, 0.0, 0.0));
        this.player1.setValue("Player1");
        this.player1.setPaint(Color.WHITE);
        this.player1.setOpacity(1.0);
        this.player1.setName("player1");
        this.player1.setVehicle(this);
        this.player1.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.player1.setPositionRelativeToVehicle(new Position(1.5, 1.5, -3.0));
        this.player1.setScale(new Scale(0.0266, 0.0266, 0.0266));
        this.castleWall.setPaint(Color.WHITE);
        this.castleWall.setOpacity(1.0);
        this.castleWall.setName("castleWall");
        this.castleWall.setVehicle(this);
        this.castleWall.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.castleWall.setPositionRelativeToVehicle(new Position(0.0, 0.0, 0.0));
        this.player2.setValue("Player2");
        this.player2.setPaint(Color.WHITE);
        this.player2.setOpacity(1.0);
        this.player2.setName("player2");
        this.player2.setVehicle(this);
        this.player2.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.player2.setPositionRelativeToVehicle(new Position(-1.5, 1.5, -3.0));
        this.player2.setScale(new Scale(0.0256, 0.0256, 0.0256));
        this.win1sign.setValue("Win !!!");
        this.win1sign.setPaint(Color.WHITE);
        this.win1sign.setOpacity(0.0);
        this.win1sign.setName("win1sign");
        this.win1sign.setVehicle(this);
        this.win1sign.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.win1sign.setPositionRelativeToVehicle(new Position(1.5, 1.0, -3.0));
        this.win1sign.setScale(new Scale(0.0303, 0.0303, 0.0303));
        this.win2sign.setValue("Win !!!");
        this.win2sign.setPaint(Color.WHITE);
        this.win2sign.setOpacity(0.0);
        this.win2sign.setName("win2sign");
        this.win2sign.setVehicle(this);
        this.win2sign.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.win2sign.setPositionRelativeToVehicle(new Position(-1.5, 1.0, -3.0));
        this.win2sign.setScale(new Scale(0.0303, 0.0303, 0.0303));
        this.p1ScoreSign.setValue("Score : 0");
        this.p1ScoreSign.setPaint(Color.WHITE);
        this.p1ScoreSign.setOpacity(1.0);
        this.p1ScoreSign.setName("p1ScoreSign");
        this.p1ScoreSign.setVehicle(this);
        this.p1ScoreSign.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.p1ScoreSign.setPositionRelativeToVehicle(new Position(1.5, 0.5, -3.0));
        this.p1ScoreSign.setScale(new Scale(0.0213, 0.0213, 0.0213));
        this.p2ScoreSign.setValue("Score : 0");
        this.p2ScoreSign.setPaint(Color.WHITE);
        this.p2ScoreSign.setOpacity(1.0);
        this.p2ScoreSign.setName("p2ScoreSign");
        this.p2ScoreSign.setVehicle(this);
        this.p2ScoreSign.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.p2ScoreSign.setPositionRelativeToVehicle(new Position(-1.5, 0.5, -3.0));
        this.p2ScoreSign.setScale(new Scale(0.0213, 0.0213, 0.0213));
        this.cone1.setBaseRadius(0.125);
        this.cone1.setLength(0.25);
        this.cone1.setPaint(Color.WHITE);
        this.cone1.setOpacity(0.0);
        this.cone1.setName("cone1");
        this.cone1.setVehicle(this);
        this.cone1.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.cone1.setPositionRelativeToVehicle(new Position(0.5, 0.0, -3.0));
        this.cone2.setBaseRadius(0.125);
        this.cone2.setLength(0.25);
        this.cone2.setPaint(Color.WHITE);
        this.cone2.setOpacity(0.0);
        this.cone2.setName("cone2");
        this.cone2.setVehicle(this);
        this.cone2.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.cone2.setPositionRelativeToVehicle(new Position(-0.5, 0.0, -3.0));
        this.originalCamera.setName("originalCamera");
        this.originalCamera.setVehicle(this);
        this.originalCamera.setOrientationRelativeToVehicle(new Orientation(-7.69751E-4, 0.995447, 0.0949724, 0.00805735));
        this.originalCamera.setPositionRelativeToVehicle(new Position(0.385, 2.0, -9.26));
        this.originalCamera.setColorId(Color.RED);
        this.coneOutside.setBaseRadius(0.125);
        this.coneOutside.setLength(0.25);
        this.coneOutside.setPaint(Color.WHITE);
        this.coneOutside.setOpacity(1.0);
        this.coneOutside.setName("coneOutside");
        this.coneOutside.setVehicle(this);
        this.coneOutside.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.coneOutside.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard1.setPaint(Color.WHITE);
        this.playingCard1.setOpacity(1.0);
        this.playingCard1.setName("playingCard1");
        this.playingCard1.setVehicle(this);
        this.playingCard1.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard1.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard1.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard1.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard1.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard1.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard1.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard1.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard1.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard1.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard1.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard1.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard1.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard1.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard1.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard1.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard1.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard1.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard1.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard1.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard1.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard1.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard1.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard1.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard1.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard1.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard1.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard1.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard1.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard1.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard1.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard1.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard1.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard1.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard1.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard1.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard1.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard1.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard1.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard1.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard1.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard1.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard1.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard1.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard1.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard1.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard2.setPaint(Color.WHITE);
        this.playingCard2.setOpacity(1.0);
        this.playingCard2.setName("playingCard2");
        this.playingCard2.setVehicle(this);
        this.playingCard2.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard2.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard2.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard2.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard2.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard2.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard2.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard2.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard2.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard2.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard2.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard2.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard2.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard2.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard2.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard2.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard2.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard2.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard2.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard2.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard2.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard2.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard2.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard2.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard2.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard2.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard2.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard2.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard2.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard2.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard2.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard2.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard2.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard2.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard2.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard2.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard2.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard2.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard2.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard2.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard2.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard2.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard2.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard2.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard2.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard2.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard3.setPaint(Color.WHITE);
        this.playingCard3.setOpacity(1.0);
        this.playingCard3.setName("playingCard3");
        this.playingCard3.setVehicle(this);
        this.playingCard3.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard3.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard3.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard3.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard3.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard3.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard3.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard3.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard3.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard3.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard3.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard3.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard3.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard3.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard3.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard3.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard3.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard3.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard3.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard3.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard3.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard3.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard3.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard3.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard3.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard3.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard3.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard3.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard3.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard3.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard3.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard3.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard3.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard3.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard3.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard3.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard3.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard3.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard3.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard3.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard3.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard3.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard3.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard3.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard3.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard3.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard4.setPaint(Color.WHITE);
        this.playingCard4.setOpacity(1.0);
        this.playingCard4.setName("playingCard4");
        this.playingCard4.setVehicle(this);
        this.playingCard4.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard4.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard4.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard4.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard4.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard4.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard4.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard4.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard4.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard4.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard4.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard4.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard4.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard4.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard4.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard4.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard4.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard4.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard4.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard4.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard4.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard4.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard4.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard4.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard4.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard4.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard4.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard4.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard4.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard4.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard4.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard4.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard4.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard4.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard4.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard4.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard4.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard4.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard4.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard4.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard4.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard4.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard4.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard4.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard4.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard4.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard5.setPaint(Color.WHITE);
        this.playingCard5.setOpacity(1.0);
        this.playingCard5.setName("playingCard5");
        this.playingCard5.setVehicle(this);
        this.playingCard5.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard5.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard5.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard5.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard5.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard5.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard5.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard5.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard5.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard5.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard5.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard5.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard5.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard5.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard5.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard5.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard5.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard5.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard5.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard5.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard5.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard5.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard5.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard5.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard5.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard5.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard5.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard5.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard5.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard5.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard5.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard5.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard5.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard5.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard5.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard5.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard5.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard5.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard5.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard5.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard5.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard5.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard5.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard5.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard5.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard5.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard6.setPaint(Color.WHITE);
        this.playingCard6.setOpacity(1.0);
        this.playingCard6.setName("playingCard6");
        this.playingCard6.setVehicle(this);
        this.playingCard6.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard6.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard6.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard6.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard6.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard6.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard6.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard6.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard6.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard6.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard6.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard6.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard6.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard6.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard6.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard6.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard6.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard6.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard6.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard6.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard6.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard6.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard6.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard6.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard6.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard6.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard6.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard6.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard6.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard6.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard6.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard6.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard6.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard6.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard6.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard6.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard6.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard6.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard6.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard6.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard6.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard6.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard6.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard6.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard6.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard6.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard7.setPaint(Color.WHITE);
        this.playingCard7.setOpacity(1.0);
        this.playingCard7.setName("playingCard7");
        this.playingCard7.setVehicle(this);
        this.playingCard7.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard7.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard7.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard7.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard7.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard7.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard7.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard7.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard7.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard7.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard7.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard7.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard7.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard7.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard7.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard7.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard7.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard7.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard7.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard7.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard7.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard7.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard7.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard7.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard7.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard7.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard7.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard7.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard7.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard7.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard7.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard7.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard7.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard7.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard7.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard7.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard7.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard7.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard7.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard7.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard7.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard7.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard7.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard7.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard7.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard7.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard8.setPaint(Color.WHITE);
        this.playingCard8.setOpacity(1.0);
        this.playingCard8.setName("playingCard8");
        this.playingCard8.setVehicle(this);
        this.playingCard8.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard8.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard8.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard8.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard8.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard8.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard8.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard8.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard8.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard8.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard8.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard8.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard8.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard8.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard8.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard8.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard8.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard8.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard8.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard8.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard8.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard8.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard8.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard8.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard8.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard8.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard8.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard8.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard8.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard8.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard8.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard8.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard8.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard8.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard8.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard8.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard8.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard8.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard8.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard8.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard8.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard8.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard8.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard8.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard8.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard8.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard9.setPaint(Color.WHITE);
        this.playingCard9.setOpacity(1.0);
        this.playingCard9.setName("playingCard9");
        this.playingCard9.setVehicle(this);
        this.playingCard9.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard9.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard9.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard9.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard9.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard9.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard9.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard9.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard9.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard9.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard9.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard9.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard9.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard9.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard9.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard9.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard9.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard9.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard9.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard9.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard9.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard9.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard9.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard9.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard9.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard9.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard9.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard9.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard9.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard9.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard9.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard9.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard9.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard9.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard9.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard9.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard9.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard9.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard9.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard9.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard9.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard9.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard9.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard9.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard9.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard9.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.playingCard10.setPaint(Color.WHITE);
        this.playingCard10.setOpacity(1.0);
        this.playingCard10.setName("playingCard10");
        this.playingCard10.setVehicle(this);
        this.playingCard10.setOrientationRelativeToVehicle(new Orientation(0.0, -0.00810473, 0.0, 0.999967));
        this.playingCard10.setPositionRelativeToVehicle(new Position(8.0, 0.0, -3.0));
        this.playingCard10.setScale(new Scale(0.874, 0.874, 0.874));
        this.playingCard10.getSpineMiddle().setPositionRelativeToVehicle(new Position(0.0, 0.0, -0.174));
        this.playingCard10.getSpineUpper().setPositionRelativeToVehicle(new Position(2.93E-19, 4.66E-17, -0.232));
        this.playingCard10.getNeck().setPositionRelativeToVehicle(new Position(-4.08E-17, 0.0, -0.0966));
        this.playingCard10.getHead().setPositionRelativeToVehicle(new Position(3.39E-16, 0.0, -0.0503));
        this.playingCard10.getMouth().setPositionRelativeToVehicle(new Position(1.49E-15, 0.0263, -0.0337));
        this.playingCard10.getRightEye().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard10.getLeftEye().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard10.getLeftEyelid().setPositionRelativeToVehicle(new Position(-0.0436, 0.163, -0.0735));
        this.playingCard10.getRightEyelid().setPositionRelativeToVehicle(new Position(0.0436, 0.163, -0.0735));
        this.playingCard10.getRightHip().setPositionRelativeToVehicle(new Position(0.112, 0.0254, -0.0856));
        this.playingCard10.getRightKnee().setPositionRelativeToVehicle(new Position(1.55E-17, 1.13E-15, -0.179));
        this.playingCard10.getRightAnkle().setPositionRelativeToVehicle(new Position(1.55E-17, 5.13E-16, -0.202));
        this.playingCard10.getRightFoot().setPositionRelativeToVehicle(new Position(-4.66E-17, -1.16E-16, -0.143));
        this.playingCard10.getLeftHip().setPositionRelativeToVehicle(new Position(-0.112, 0.0254, -0.0856));
        this.playingCard10.getLeftKnee().setPositionRelativeToVehicle(new Position(3.11E-17, 3.96E-16, -0.179));
        this.playingCard10.getLeftAnkle().setPositionRelativeToVehicle(new Position(6.21E-17, -1.94E-16, -0.202));
        this.playingCard10.getLeftFoot().setPositionRelativeToVehicle(new Position(1.1E-15, 0.0, -0.143));
        this.playingCard10.getRightClavicle().setPositionRelativeToVehicle(new Position(0.0926, -0.024, -0.0069));
        this.playingCard10.getRightShoulder().setPositionRelativeToVehicle(new Position(6.02E-17, 2.48E-16, -0.0991));
        this.playingCard10.getRightElbow().setPositionRelativeToVehicle(new Position(-4.43E-16, 0.0, -0.21));
        this.playingCard10.getRightWrist().setPositionRelativeToVehicle(new Position(-3.11E-16, 1.24E-16, -0.199));
        this.playingCard10.getRightHand().setPositionRelativeToVehicle(new Position(-1.01E-16, -2.48E-16, -0.0473));
        this.playingCard10.getRightThumb().setPositionRelativeToVehicle(new Position(1.24E-16, 4.97E-16, -0.0375));
        this.playingCard10.getRightThumbKnuckle().setPositionRelativeToVehicle(new Position(-4.97E-16, -2.48E-16, -0.0325));
        this.playingCard10.getRightIndexFinger().setPositionRelativeToVehicle(new Position(0.0641, 0.0017, -0.0363));
        this.playingCard10.getRightIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-6.21E-17, -1.13E-12, -0.0341));
        this.playingCard10.getRightMiddleFinger().setPositionRelativeToVehicle(new Position(0.072, 0.00327, -0.0207));
        this.playingCard10.getRightMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(9.32E-17, -3.73E-16, -0.0362));
        this.playingCard10.getRightPinkyFinger().setPositionRelativeToVehicle(new Position(0.0688, -4.97E-16, 0.02));
        this.playingCard10.getRightPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, -5.72E-14, -0.0271));
        this.playingCard10.getLeftClavicle().setPositionRelativeToVehicle(new Position(-0.0926, -0.024, -0.0069));
        this.playingCard10.getLeftShoulder().setPositionRelativeToVehicle(new Position(-5.24E-17, 2.48E-16, -0.0991));
        this.playingCard10.getLeftElbow().setPositionRelativeToVehicle(new Position(2.48E-16, 1.19E-13, -0.21));
        this.playingCard10.getLeftWrist().setPositionRelativeToVehicle(new Position(2.56E-16, 1.13E-13, -0.199));
        this.playingCard10.getLeftHand().setPositionRelativeToVehicle(new Position(1.01E-16, 2.48E-16, -0.0473));
        this.playingCard10.getLeftThumb().setPositionRelativeToVehicle(new Position(-2.48E-16, -3.73E-16, -0.0375));
        this.playingCard10.getLeftThumbKnuckle().setPositionRelativeToVehicle(new Position(-1.24E-16, -1.38E-14, -0.0325));
        this.playingCard10.getLeftIndexFinger().setPositionRelativeToVehicle(new Position(-0.0641, 0.00169, -0.0363));
        this.playingCard10.getLeftIndexFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 8.7E-16, -0.0341));
        this.playingCard10.getLeftMiddleFinger().setPositionRelativeToVehicle(new Position(-0.072, 0.00327, -0.0207));
        this.playingCard10.getLeftMiddleFingerKnuckle().setPositionRelativeToVehicle(new Position(-3.88E-17, 2.24E-15, -0.0362));
        this.playingCard10.getLeftPinkyFinger().setPositionRelativeToVehicle(new Position(-0.0688, -1.24E-15, 0.02));
        this.playingCard10.getLeftPinkyFingerKnuckle().setPositionRelativeToVehicle(new Position(-4.66E-17, 1.49E-15, -0.0271));
        this.creatorName.setValue("Noah Miller's Card Game");
        this.creatorName.setPaint(Color.WHITE);
        this.creatorName.setOpacity(1.0);
        this.creatorName.setName("creatorName");
        this.creatorName.setVehicle(this);
        this.creatorName.setOrientationRelativeToVehicle(new Orientation(0.0, -0.0102965, 0.0, 0.999947));
        this.creatorName.setPositionRelativeToVehicle(new Position(0.0, 1.25, -2.0));
        this.creatorName.setScale(new Scale(0.00991, 0.00991, 0.00991));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="/* Procedures and functions to handle multiple scenes */">
    @Override
    protected void handleActiveChanged(Boolean isActive, Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public SGround getGround() {
        return this.ground;
    }

    public SCamera getCamera() {
        return this.camera;
    }

    public CastleWall getCastleWall2() {
        return this.castleWall2;
    }

    public TextModel getPlayer1() {
        return this.player1;
    }

    public CastleWall getCastleWall() {
        return this.castleWall;
    }

    public TextModel getPlayer2() {
        return this.player2;
    }

    public TextModel getWin1sign() {
        return this.win1sign;
    }

    public TextModel getWin2sign() {
        return this.win2sign;
    }

    public TextModel getP1ScoreSign() {
        return this.p1ScoreSign;
    }

    public TextModel getP2ScoreSign() {
        return this.p2ScoreSign;
    }

    public Cone getCone1() {
        return this.cone1;
    }

    public Cone getCone2() {
        return this.cone2;
    }

    public SCameraMarker getOriginalCamera() {
        return this.originalCamera;
    }

    public Cone getConeOutside() {
        return this.coneOutside;
    }

    public PlayingCard getPlayingCard1() {
        return this.playingCard1;
    }

    public PlayingCard getPlayingCard2() {
        return this.playingCard2;
    }

    public PlayingCard getPlayingCard3() {
        return this.playingCard3;
    }

    public PlayingCard getPlayingCard4() {
        return this.playingCard4;
    }

    public PlayingCard getPlayingCard5() {
        return this.playingCard5;
    }

    public PlayingCard getPlayingCard6() {
        return this.playingCard6;
    }

    public PlayingCard getPlayingCard7() {
        return this.playingCard7;
    }

    public PlayingCard getPlayingCard8() {
        return this.playingCard8;
    }

    public PlayingCard getPlayingCard9() {
        return this.playingCard9;
    }

    public PlayingCard getPlayingCard10() {
        return this.playingCard10;
    }

    public TextModel getCreatorName() {
        return this.creatorName;
    }
    // </editor-fold>
}

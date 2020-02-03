// <editor-fold defaultstate="collapsed" desc="imports">

import org.lgna.story.resources.biped.PlayingCardResource;
// </editor-fold>

class PlayingCard extends Biped {

    /* Construct new PlayingCard */
    public PlayingCard(PlayingCardResource resource) {
        super(resource);
    }

    public void standingPose() {
        this.strikePose(PlayingCardResource.STANDING_POSE);
    }

    public void tunnelPose() {
        this.strikePose(PlayingCardResource.TUNNEL_POSE);
    }

    public void setPlayingCardResource(PlayingCardResource playingCardResource) {
        this.setJointedModelResource(playingCardResource);
    }
}

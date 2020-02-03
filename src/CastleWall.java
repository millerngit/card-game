// <editor-fold defaultstate="collapsed" desc="imports">

import org.lgna.story.resources.prop.CastleWallResource;
// </editor-fold>

class CastleWall extends Prop {

    /* Construct new CastleWall */
    public CastleWall(CastleWallResource resource) {
        super(resource);
    }

    public void setCastleWallResource(CastleWallResource castleWallResource) {
        this.setJointedModelResource(castleWallResource);
    }
}

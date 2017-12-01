package com.jaredscarito.jaredsplatformer.shapes;

/**
 * Created by user on 11/30/2017.
 */
public class ShapeCollideable {

    public boolean collides(Shape shape1, Shape shape2) {
        for(int shape1X=0; shape1X < shape1.getPointsX().length; shape1X++) {
            int shape1Xval = shape1.getPointsX()[shape1X];
            int shape1Yval = shape1.getPointsY()[shape1X];
            for(int shape2X=0; shape1X < shape1.getPointsX().length; shape2X++) {
                int shape2Xval = shape2.getPointsX()[shape2X];
                int shape2Yval = shape2.getPointsY()[shape2X];
                if(shape1Xval == shape2Xval && shape1Yval == shape2Yval) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collides(Shape shape1, Shape shape2, int pixels) {
        int count = 0;
        for(int shape1X=0; shape1X < shape1.getPointsX().length; shape1X++) {
            for(int shape1Y=0; shape1Y < shape1.getPointsY().length; shape1Y++) {
                int shape1Xval = shape1.getPointsX()[shape1X];
                int shape1Yval = shape1.getPointsY()[shape1Y];
                for(int shape2X=0; shape1X < shape1.getPointsX().length; shape2X++) {
                    for(int shape2Y = 0; shape1Y < shape1.getPointsY().length; shape2X++) {
                        int shape2Xval = shape2.getPointsX()[shape2X];
                        int shape2Yval = shape2.getPointsY()[shape2Y];
                        if(shape1Xval == shape2Xval && shape1Yval == shape2Yval) {
                            count++;
                        }
                    }
                }
            }
        }
        return (count >= pixels);
    }
}

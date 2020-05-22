                  /*  File:  fenceB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fenceB extends Template {

     static {templateClass = new fenceB() ; }

     public void setup() {
          filePrefix = "fenceB" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -50 ;
          xmax = 50 ;
          ymin = -45 ;
          ymax = 5 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double x = 30 ;
          double th = 60 ;
          double costh = Math.cos(th*Math.PI/180) ;
          double sinth = Math.sin(th*Math.PI/180) ;

          fEnv("psFillGray", 0.9) ;
          {double[] xlist = {-50+x-x*costh,    -50+x,     50-x, 50-x+x*costh} ;
           double[] ylist = {            0, -x*sinth, -x*sinth, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
          }

          fEnv("lineWidth", 2.0) ;
          fLine(-50+x-x*costh,0, -50,0) ;
          fLine( 50-x+x*costh,0, 50,0) ;

          fEnv("lineWidth", 1.0) ;
          fLine(50-x,-x*sinth, -50+x,-x*sinth) ;

          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          {double[] xlist = {-50+x-x*costh,    -50+x,     50-x, 50-x+x*costh} ;
           double[] ylist = {            0, -x*sinth, -x*sinth,          0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
          }
          fLine( 50-x,-x*sinth,  50-x,0) ;
          fLine(-50+x,-x*sinth, -50+x,0) ;

          fEnv("lineWidth", 2.0) ;
          fLine(-50+x-x*costh,0, 50-x+x*costh,0) ;



          
          
     }
}

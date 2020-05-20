                  /*  File:  OE06A_7p.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_7p extends Template {

     static {templateClass = new OE06A_7p() ; }

     public void setup() {
          filePrefix = "OE06A_7p" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.6 ;      // in inches
          ysize = 2.4*0.6 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 2.5 ;
          ymin = -0.1 ;
          ymax = 2.3 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0, 2,2, 0, 90, FILLED) ;
         { 
            double[] xlist = { 0, 2,  1.2, 0} ;
            double[] ylist = { 0, 0,  1,2, 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fTeXlabel(1.53,1.5, "cl", "$r=2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0, 90, OPEN) ;
          fLine(0,0, 2,0) ;
          fLine(0,0, 0,2) ;


//          fEnv("psFillGray", 0.0) ;
//          double r = 0.04 ;
//          fDisk(2, 0, r, r, FILLED) ;
//          fTeXlabel(2.0, -0.07, "ct", "$\\scriptstyle (0,2)$") ;

          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 10 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2 ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, 0.9*r,0.9*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 0.78*r,0.78*r, th,th+dth, WEDGE+FILLED) ;
        
     }
}

                  /*  File:  OE07A_8s.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE07A_8s extends Template {

     static {templateClass = new OE07A_8s() ; }

     public void setup() {
          filePrefix = "OE07A_8s" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.5*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -2.25 ;
          xmax =  2.25 ;
          ymin = -0.2 ;
          ymax =  2.4 ;
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
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { -2, -2,  0, 2, 2, -2} ;
            double[] ylist = {  0,  2,  0, 2, 0, 0} ;
            fPolygon(xlist, ylist, 6, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;
          fLine(0,0, xmax, xmax) ;

          fTeXlabel(2.1, 0.7, "cl", "$\\rho\\sin\\varphi=2$") ;
          fTeXlabel(1.35, 1.5, "cr", "$\\varphi=\\frac{\\pi}{4}$") ;
          fTeXlabel(-1.5, 0.8, "cc", "$U$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { -2, -2,  0, 2, 2, -2} ;
            double[] ylist = {  0,  2,  0, 2, 0, 0} ;
            fPolygon(xlist, ylist, 6, OPEN) ;
           }             
             

//          double r = 0.07 ;
//          fEnv("psFillGray", 0.0) ;
//          fDisk(2,2, r,r, FILLED) ;
//          fTeXlabel(2.1, 2.0, "tl",  "$\\scriptstyle r=2,\\ z=2$") ;

          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 10 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2/Math.cos(thRad+dthRad) ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, 0.6*r,0.6*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 0.48*r,0.48*r, th,th+dth, WEDGE+FILLED) ;
//          fEllipticalArc(0,0, 0.1*r,0.1*r, 0, th, OPEN) ;


          
     }
}

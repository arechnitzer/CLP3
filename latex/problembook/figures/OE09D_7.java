                  /*  File:  OE09D_7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE09D_7 extends Template {

     static {templateClass = new OE09D_7() ; }

     public void setup() {
          filePrefix = "OE09D_7" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.6 ;      // in inches
          ysize = 3.0*0.6 ;   // in inches. 
          xmin = -1.3 ;
          xmax = 1.3;
          ymin = -0.6 ;
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
          double pi = Math.PI ;
          fEnv("psFillGray", 0.9) ;
          fCurve("[ (1+sin(t))*cos(t) , (1+sin(t))*sin(t)]",1, 0,pi/2, FILLED) ;
         { 
            double[] xlist = { 0, 1,  1, 0, 0} ;
            double[] ylist = { 0, 0,  1, 2, 0} ;
            fPolygon(xlist, ylist, 5, FILLED) ;
           }    
                       

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fCurve("[ (1+sin(t))*cos(t) , (1+sin(t))*sin(t)]",1, 0,2*pi, OPEN) ;

          double th = 60 ; double thRad = th*Math.PI/180 ;
          double dth = 10 ;  double dthRad = dth*Math.PI/180 ;
          double r = 1+Math.sin(thRad+dthRad) ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, 0.6*r,0.6*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 0.48*r,0.48*r, th,th+dth, WEDGE+FILLED) ;
          fEllipticalArc(0,0, 0.1*r,0.1*r, 0, th, OPEN) ;
          fTeXlabel(0.2, 0.1, "bl", "$\\theta$") ;
          fTeXlabel(0.7, 0.7, "cl", "$\\cP$") ;



          fTeXlabel(xmax+0.05, 1, "lc", "$r=1+\\sin\\theta$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[ (1+sin(t))*cos(t) , (1+sin(t))*sin(t)]",1, 0,pi/2, OPEN) ;
          fLine(0,0, 1,0) ;
          fLine(0,0, 0,2) ;
          
     }
}

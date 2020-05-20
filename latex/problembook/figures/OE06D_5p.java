                  /*  File:  OE06D_5p.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06D_5p extends Template {

     static {templateClass = new OE06D_5p() ; }

     public void setup() {
          filePrefix = "OE06D_5p" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
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
          double sq2 = Math.sqrt(2) ;
          fEllipticalArc(0,0, 2,2, 0,45, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, sq2,sq2, 0,45, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fEllipticalArc(0,0, 2,2, 0,60, OPEN) ;
          fEllipticalArc(0,0, sq2,sq2, -30,45, OPEN) ;


          fTeXlabel(0.95, 1.75, "cr", "$r=2$") ;
          fTeXlabel(sq2-0.1, -0.2, "tc", "$r=\\sqrt{2}$") ;
          fTeXlabel(xmax+0.05, xmax, "cl", "$\\theta=\\frac{\\pi}{4}$") ;
//          fTeXlabel(-1.5, 0.8, "cc", "$U$") ;

             

//          double r = 0.07 ;
//          fEnv("psFillGray", 0.0) ;
//          fDisk(2,2, r,r, FILLED) ;
//          fTeXlabel(2.1, 2.0, "tl",  "$\\scriptstyle r=2,\\ z=2$") ;

          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2 ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, 0.93*r,0.93*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 0.83*r,0.83*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, sq2,sq2, th-5,th+dth+5, WEDGE+FILLED) ;
          double x = sq2*Math.cos(thRad) ; double y = sq2*Math.sin(thRad) ; 
          fLine(0,0, x,y) ;
          x = sq2*Math.cos(thRad+dthRad) ; y = sq2*Math.sin(thRad+dthRad) ; 
          fLine(0,0, x,y) ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0,45, OPEN) ;
          fEllipticalArc(0,0, sq2,sq2, 0,45, OPEN) ;
          fLine(1,1, sq2,sq2) ;
          fLine(sq2,0,  2,0) ;

          
     }
}

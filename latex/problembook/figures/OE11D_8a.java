                  /*  File:  OE11D_8a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11D_8a extends Template {

     static {templateClass = new OE11D_8a() ; }

     public void setup() {
          filePrefix = "OE11D_8a" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 10.0*0.2 ;      // in inches
          ysize = 11.0*0.2 ;   // in inches. 
          xmin = -5.0 ;
          xmax = 5.0 ;
          ymin = -4.25 ;
          ymax =  6.75 ;
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
          double sq12 = Math.sqrt(12) ;
          fDisk(0,0, sq12,sq12, FILLED) ;
          fDisk(0,4, 2,2, FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, sq12, sq12, 60,120, FILLED) ;
          fEllipticalArc(0,4, 2,2,-150, -30, FILLED) ;
//          { 
//            double[] xlist = { 0, 1,  2} ;
//            double[] ylist = { 2, 0,  0} ;
//            fPolygon(xlist, ylist, 3, FILLED) ;
//           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$z$") ;
          fDisk(0,0, sq12,sq12, CLOSED) ;
          fDisk(0,4, 2,2, CLOSED) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine(-3,3,  3,3) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(3.2, 3, "lc", "$z=3$") ;
          fTeXlabel(-2.0, 5, "rc", "$x^2+y^2+(z-4)^2=4$") ;
          fTeXlabel(-3.2, -2, "rc", "$x^2+y^2+z^2=12$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, sq12, sq12, 120,420, OPEN) ;
          fEllipticalArc(0,4, 2,2,-30, 210, OPEN) ;
          
     }
}

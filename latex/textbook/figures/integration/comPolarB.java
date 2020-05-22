                  /*  File:  comPolarB.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class comPolarB extends Template {

     static {templateClass = new comPolarB() ; }

     public void setup() {
          filePrefix = "comPolarB" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*0.7 ;      // in inches
          ysize = 3*0.7 ;   // in inches. 
          xmin = -1 ;
          xmax = 2 ;
          ymin = -0.5 ;
          ymax = 2.5 ;
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
          double th = 60; double thRad = th*Math.PI/180 ;
          double Y = 2*Math.sin(thRad) ;
          double rr = 0.06 ;

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(2,0, 2,2, 180-th, 180+th, FILLED) ;

          fEnv("psFillGray", 1.0) ;
          { 
            double[] xlist = { xmin, xmin, xmax, xmax} ;
            double[] ylist = { -1,    0,    0, -1} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }     

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1 , "tr", "$x$") ;
          fTeXlabel(-0.05, ymax , "tr", "$y$") ; 
          fLine(1,ymin, 1,Y) ;
          th =70 ; thRad = th*Math.PI/180 ;
          double x = 2*Math.cos(thRad) ;
          double y = 2*Math.sin(thRad) ;
          fLine(0,0, x,y) ;
          fTeXlabel(x-0.05, y , "bc",  "$\\theta > \\nicefrac{\\pi}{3}$") ;         
          th =45 ; thRad = th*Math.PI/180 ;
          x = 2*Math.cos(thRad) ;
          y = 2*Math.sin(thRad) ;
          fLine(0,0, x,y) ;   
          fTeXlabel(x+0.1, y , "lc", "$\\theta < \\nicefrac{\\pi}{3}$") ;         
      
 

          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
          fLine(0,0, 5,5*Y) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          th =60 ; thRad = th*Math.PI/180 ;
          fEllipticalArc(2,0, 2,2, 0, 360, OPEN) ;
      
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;

          fEllipticalArc(2,0, 2,2, 180-th, 180, OPEN) ;
          fLine(1,0, 1,Y) ;
          fLine(0,0, 1,0) ;

          fTeXlabel(xmax+0.1, 2.0, "cl", "$r=4\\cos\\theta$") ;
          fTeXlabel(0.7, 0.2 , "bc", "$\\cR_1$") ;
          fTeXlabel(1.05, ymin , "tc", "$r=\\frac{1}{\\cos\\theta}$") ;
          fTeXlabel(1.6, ymax , "bc", "$\\theta=\\nicefrac{\\pi}{3}$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fDisk(1,Y, rr, rr, FILLED) ;


     }
}

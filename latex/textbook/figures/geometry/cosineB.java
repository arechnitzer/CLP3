                  /*  File:  cosineB.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cosineB extends Template {

     static {templateClass = new cosineB() ; }

     public void setup() {
          filePrefix = "cosineB" ;    // used as the prefix for ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4*1.2 ;      // in inches
          ysize = 1.2*1.2 ;   // in inches. 
          xmin = -20 ;
          xmax = 260 ;
          ymin = -20 ;
          ymax = 40 ;
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
     String Red = "0 1 1 0 setcmykcolor  " ;
     String Black = "0 0 0 1 setcmykcolor  " ;
     double X = 70 ;
//  Left half

     fTranslate( -20, 0) ;
     fEnv("lineWidth", 0.5) ;

     fTeXlabel(60, -5, "cc", "$\\vb$") ;

     fTeXlabel(16, 3.6, "cc", "$\\theta$") ;
     canvas.append( new fPsWrite(Red+"\n")) ;
     fEllipticalArc( 0, 0, 10, 10, 0, 25, OPEN) ;

     canvas.append( new fPsWrite(Black+"\n")) ;
     fEnv("lineWidth", 1) ;
     fEnv("headHalfWidth", 2*1.3) ;
     fEnv("headLength", 6*1.3) ;
     fArrow(0, 0, 120, 0) ;
     fArrow(0, 0, X, 30) ;
     fArrow(120, 0,  X, 30) ;


     fTeXlabel(28, 16, "bc", "$\\va$") ;
     fTeXlabel(97, 16, "bl", "$\\va-\\vb$") ;
          
//   Right half
     fTranslate(160, 0) ;

     fEnv("psFillGray", 0.8) ;
     {double[] xlist = {X, 120, X} ;
      double[] ylist = { 0,   0, 30} ;
      fPolygon(xlist, ylist, 3, FILLED) ;}

     canvas.append( new fPsWrite(Red+"\n")) ;
     fEnv("lineWidth", 0.5) ;

     fLine(X, 30, X, 0) ;
     fLine(X, 4, X-4, 4) ;
     fLine(X-4, 0, X-4, 4) ;

     fLine(0, -2, 0, -20) ;
     fLine(120, -2,   120, -20) ;

     fEnv("headHalfWidth", 2) ;
     fEnv("headLength", 6) ;
     fTeXlabel(60, -6, "cc", "$|\\vb|$") ;
     fArrow(51, -6, 1, -6) ;
     fArrow(69, -6, 119, -6) ;
     fLine(X, -12,   X, -20) ;

     fTeXlabel(30, -16, "cc", "$|\\va|\\cos\\theta$") ;
     fArrow(12, -16, 1, -16) ;
     fArrow(49, -16, 59, -16) ;


     fLine(-10, 0, -2, 0) ;
     fLine(-10, 30, -2, 30) ;
     fTeXlabel(-5, 15, "cc", "$|\\va|\\sin\\theta$") ;
     fArrow(-6, 19, -6, 29) ;
     fArrow(-6, 10, -6, 1) ;

     fTeXlabel(16, 3.6, "cc", "$\\theta$") ;
     fEllipticalArc( 0, 0, 10, 10, 0, 25, OPEN) ;

     fTeXlabel(28, 16, "bc", "$|\\va|$") ;
     fTeXlabel(97, 16, "bl", "$|\\va-\\vb|$") ;

     fEnv("lineWidth", 1) ;
     canvas.append( new fPsWrite(Black+"\n")) ;
     fLine(0, 0, 120, 0) ;
     fLine(0, 0, X, 30) ;
     fLine(120, 0,  X, 30) ;


     }
}

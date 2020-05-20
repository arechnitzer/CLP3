                  /*  File:  comPolarC.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class comPolarC extends Template {

     static {templateClass = new comPolarC() ; }

     public void setup() {
          filePrefix = "comPolarC" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6*0.5 ;      // in inches
          ysize = 6*0.5 ;   // in inches. 
          xmin = -1 ;
          xmax = 5 ;
          ymin = -3 ;
          ymax = 3 ;
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
          double th = 60; double thRad = 60*Math.PI/180 ;
          double Y = 2*Math.sin(thRad) ;
          double rr = 0.1 ;

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(2,0, 2,2, 180-th, 180+th, WEDGE+FILLED) ;
          fTeXlabel(1,-0.7 , "cc", "$\\cW$") ;

//          { 
//            double[] xlist = { 1, 0, 1, 2, 1} ;
//            double[] ylist = { Y, 0, -Y,0, Y} ;
//            fPolygon(xlist, ylist, 5, FILLED) ;
//           }     

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1 , "tr", "$x$") ;
          fTeXlabel(-0.05, ymax , "tr", "$y$") ; 
          fLine(1,0, 1,ymax) ;
          fEllipticalArc(2,0, 0.3,0.3, 120, 180, OPEN) ;
          fTeXlabel(1.7, 0.1 , "br", "$\\nicefrac{\\pi}{3}$") ;


 

//          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
//          fLine(0,0, 5,5*Y) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEllipticalArc(2,0, 2,2, 0, 360, OPEN) ;
      
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;

          fEllipticalArc(2,0, 2,2, 180-th, 180+th, OPEN) ;
          fLine(1,-Y, 2,0) ;
          fLine(1, Y, 2,0) ;

//          fTeXlabel(2.8, -2.05, "tc", "$r=4\\cos\\theta$") ;
//          fTeXlabel(0.6, -0.5 , "cc", "$\\cR$") ;
          fTeXlabel(1.0, ymax+0.05 , "bc", "$x=1$") ;
//          fTeXlabel(2.2, ymax , "bc", "$\\theta=\\nicefrac{\\pi}{3}$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fDisk(1,Y, rr, rr, FILLED) ;       fTeXlabel(0.9,Y+0.1, "br", "$A$") ;
//          fDisk(0,0, rr, rr, FILLED) ;       fTeXlabel(-0.1,0.1, "br", "$A$") ;
          fDisk(2,0, rr, rr, FILLED) ;       fTeXlabel( 2.1,0.1, "bl", "$C$") ;

          fTeXlabel(0.5,0.1, "bc", "$1$") ;      
          fTeXlabel(1.5,-0.1, "tc", "$1$") ;
          fTeXlabel(1.6,0.8, "bl", "$2$") ;


     }
}

                  /*  File:  comPolar.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class comPolar extends Template {

     static {templateClass = new comPolar() ; }

     public void setup() {
          filePrefix = "comPolar" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 8*0.3 ;      // in inches
          ysize = 6*0.3 ;   // in inches. 
          xmin = -3 ;
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

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, 2,2, -th, th, FILLED) ;
          fEllipticalArc(2,0, 2,2, 180-th, 180+th, FILLED) ;

          { 
            double[] xlist = { 1, 0, 1, 2, 1} ;
            double[] ylist = { Y, 0, -Y,0, Y} ;
            fPolygon(xlist, ylist, 5, FILLED) ;
           }     

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1 , "tr", "$x$") ;
          fTeXlabel(-0.05, ymax , "tr", "$y$") ;  

          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
          fLine(1,ymin, 1,ymax) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEllipticalArc(0,0, 2,2, 0, 360, OPEN) ;
          fEllipticalArc(2,0, 2,2, 0, 360, OPEN) ;
      
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;

          fEllipticalArc(0,0, 2,2, -th, th, OPEN) ;
          fEllipticalArc(2,0, 2,2, 180-th, 180+th, OPEN) ;

          fTeXlabel(-1.85, 1 , "br", "$r=2$") ;
          fTeXlabel(2.6, 2.15, "bc", "$r=4\\cos\\theta$") ;
          fTeXlabel(0.6, 0.5 , "cc", "$\\cR$") ;
          fTeXlabel(1, ymax+0.1 , "bc", "$x=1$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;


     }
}

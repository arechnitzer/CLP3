                  /*  File:  convPolarC.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class convPolarC extends Template {

     static {templateClass = new convPolarC() ; }

     public void setup() {
          filePrefix = "convPolarC" ;  // prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.4 ;
          ymin = -0.1 ;
          ymax = 1.4 ;
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
          double th1 = 15; double th1Rad = th1*Math.PI/180 ;
          double th2 = 25; double th2Rad = th2*Math.PI/180 ;
          double y1 = Math.tan(th1Rad) ;
          double y2 = Math.tan(th2Rad) ;
          double r1 = 0.8 ;
          double r2 = 0.65 ;
          double rr = 0.1 ;

          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = {0, 1, 1, 0} ;
            double[] ylist = {0, 0, 1, 0} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }     


          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = {0,  1, 1, 0} ;
            double[] ylist = {0, y1, y2, 0} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }     

          fEnv("psFillGray", 0.0) ;
          fEllipticalArc(0,0, r1,r1, th1, th2, WEDGE+FILLED) ;

          fEnv("psFillGray", 0.7) ;
          fEllipticalArc(0,0, r2,r2, th1, th2, WEDGE+FILLED) ;



          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ; 
          fLine(1,ymin, 1,ymax) ;
          fLine(0,0, 1.3,1.3) ;
 

//          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
//          fLine(0,0, 5,5*Y) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

      
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;

          { 
            double[] xlist = {0, 1, 1, 0} ;
            double[] ylist = {0, 0, 1, 0} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           }     

          fTeXlabel(1.33, 1.3, "cl", "$\\theta=\\nicefrac{\\pi}{4}$") ;
//          fTeXlabel(0.7, 0.5 , "cc", "$\\cR$") ;
          fTeXlabel(1.05, 0.7 , "lc", "$r=\\frac{1}{\\cos\\theta}$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(0,0, r1,r1, 0, 45, OPEN) ;
          fEllipticalArc(0,0, r2,r2, 0, 45, OPEN) ;



     }
}

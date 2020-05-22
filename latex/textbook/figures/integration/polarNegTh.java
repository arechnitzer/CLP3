                  /*  File:  polarNegTh.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarNegTh extends Template {

     static {templateClass = new polarNegTh() ; }

     public void setup() {
          filePrefix = "polarNegTh" ;    // the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.8 ;
          xmax = 0.8 ;
          ymin = -0.8 ;
          ymax = 0.8 ;
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
          fEnv("lineWidth", 1) ;
          double th = 270 ; double thRad = th*Math.PI/180.0 ;
          double r = 0.6 ;
          double x = r*Math.cos(thRad) ; double  y = r*Math.sin(thRad) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
//          canvas.append( new fPsWrite("0.8 setgray\n")) ;
//          fLine(0,0, 1,1) ;
//          canvas.append( new fPsWrite("[2.5 2.5] 1.25 setdash\n")) ;
//          fLine(0,0, -1,-1) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

//          fTeXlabel(0.5*x-0.03, 0.5*y , "br", "$r$") ;
          fTeXlabel(x+0.1, y-0.015 , "cl", 
                "$r=1$, $\\theta=-\\nicefrac{\\pi}{2}$, $\\theta=\\nicefrac{3\\pi}{2}$") ;
          fDisk(x, y, 0.05, 0.05, FILLED) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;



          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          double rr = 0.25 ;
          fEllipticalArc(0,0, rr, rr, 0,th, OPEN) ;
          fTeXlabel(-1.2*rr, 0.01 , "br", "$\\nicefrac{3\\pi}{2}$") ;    
          fArrowhead(-0.05,-rr, -15) ;      

          rr = 0.3 ;
          fEllipticalArc(0,0, rr, rr, -90,0, OPEN) ;
          fTeXlabel(1.0*rr,-0.13 , "tl", "$\\nicefrac{\\pi}{2}$") ;    
          fArrowhead(0.05,-rr, 190) ;      
     }
}

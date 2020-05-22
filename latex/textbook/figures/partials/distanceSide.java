                  /*  File:  distanceSide.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class distanceSide extends Template {

     static {templateClass = new distanceSide() ; }

     public void setup() {
          filePrefix = "distanceSide" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.7*1.0 ;      // in inches
          ysize = 2.2*1.0 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 3.5 ;
          ymin = -0.2 ;
          ymax = 2 ;
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
         fEnv("headHalfWidth", 2*1.2) ;
         fEnv("headLength", 6*1.2) ;
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$y$") ;
         fTeXlabel(-0.05, ymax, "tr", "$z$") ;

         
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.5) ;
         fCurve("[t,t*t]", 1, 0, 2.5, OPEN) ;
         fTeXlabel(Math.sqrt(ymax)-0.05, ymax-0.05, "rc", "$z=x^2+y^2$") ;

         fEnv("lineWidth", 1.0) ;
         r = 0.035 ;
         double x1 = 1.0 ; double y1 = x1*x1 ;
         double x2 = 3.0 ; 
         double x1a = 1.2 ; double y1a = x1a*x1a ;
         double x1b = 0.5 ; double y1b = x1b*x1b ;
         canvas.append( new fPsWrite(Black+"\n")) ;
         fLine(0.5,0,  2,3) ;
         fEnv("lineWidth", 0.7) ;
         fDisk(x1,y1, r,FILLED) ;
              fTeXlabel(x1-0.05,y1, "rc", "$\\scriptstyle(a\\,,\\,b\\,,\\,a^2+b^2)$") ;
         fDisk(x2,0, r,FILLED) ;
                   fTeXlabel(x2,-0.1, "tc", "$(0,3,0)$") ;
         fLine(x1,y1, x2,0) ;
         double h = 0.04 ;
         fLine(x1+2*h,y1-h, x1+h, y1-3*h) ;
         fLine(x1+h,y1-3*h, x1-h, y1-2*h) ;

//         fDisk(x1a,y1a, r,FILLED) ;
//         canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
//         fLine(x1a,y1a, x2,0) ;
//         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

         fDisk(x1b,y1b, r,FILLED) ;
//         canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
         fLine(x1b,y1b, x2,0) ;
//         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
         fArrow(-0.2, y1b, x1b-0.05,y1b) ;
            fTeXlabel(-0.22,y1b, "rc", "$(x,y,x^2+y^2)$") ;
         double m = x1b*x1b/(x1b-3) ;
         double xt = (3*m-1)/(m-2) ; double yt = 2*xt-1 ;
         fDisk(xt,yt, r,FILLED) ;
         fArrow(xt+0.7, -0.2, xt+0.04,yt-0.04) ;
            fTeXlabel(xt+0.73,-0.2, "lc", "$(x',y',z')$") ;





          
     }
}

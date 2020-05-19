                  /*  File:  momInertia.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class momInertia extends Template {

     static {templateClass = new momInertia() ; }

     public void setup() {
          filePrefix = "momInertia" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.5 ;   
          ysize = 4.0*0.5 ;   
          xmin = -4.0 ;
          xmax =  4.5 ;
          ymin = -4.0 ;
          ymax =  3.0 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          double x = 1.5 ;
          double xw = 0.37 ;
          double XMAX = 4.0 ;
          double YMAX = 2.2 ;
          double xrot = -1.0 ;
          double yrot = 2.2 ;
          double pi = 3.14159 ;

          fEnv("psFillGray", 0.9) ;
          fCurve("cos(x/2)" , 0, -pi, pi, FILLED) ;
          fCurve("0.35*(x*x-3.14159*3.14159)" , 0, -pi, pi, FILLED) ;
          { 
            double[] xlist = { -pi,  0, pi, 0} ;
            double[] ylist = {   0,  1, 0, -0.35*pi*pi} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xrot, ymin, xrot, yrot) ;
//          fTeXlabel(xrot-0.07, YMAX, "cr", "$y$") ;

          double xl = x-xw ;  double xr = x+xw ; 
          double yt = Math.cos(x/2) ;  double yb = 0.35*(x*x-pi*pi) ;
          double ytt = -0.5 ;  double ybb = -1.0 ; double yT = 1.7 ;


          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xl, xl, xr, xr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 0.5) ;
          { 
            double[] xlist = { xl,  xl,  xr,  xr} ;
            double[] ylist = { ytt, ybb, ybb, ytt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(xr, yb, xr, -4.0) ;
          fLine(xl, yb, xl, -4.0) ;
          fLine(x,yt, x, yT) ;
          fTeXlabel(0.5*xr+0.5*xl, -4.0, "cb", "$\\scriptstyle\\dee{x}$") ;
          fLine(xr, ytt, 4.0 , ytt) ;
          fLine(xr, ybb, 4.0 , ybb) ;
          fTeXlabel(4.0, 0.5*ybb+0.5*ytt, "cr", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fArrow(0.5*x+0.5*xrot-xw, yT-0.25, xrot, yT-0.25) ;
          fArrow(0.5*x+0.5*xrot+xw, yT-0.25, x, yT-0.25) ;
          fTeXlabel(0.5*x+0.5*xrot, yT-0.23, "cc", "$D$") ;
          fTeXlabel(xrot-0.07, ymin, "rb", "$\\cA$") ;

         

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double a = 0.2 ; double b=0.2*2.5 ;
          fEllipticalArc (xrot,yrot, b, a, -70, 235, OPEN) ;
          double th = 235*Math.PI/180.0 ;
//          fEnv("headHalfWidth", 2.0*1.2) ;
//          fEnv("headLength", 6.0*1.2) ;
          fArrowhead(xrot+b*Math.cos(th),   a*Math.sin(th)+yrot, -20) ;
          

//          fEnv("useColorPs", "false") ;
          fEnv("useColorPs", "true") ;
//          fEnv("lineWidth", 4.0) ;
//          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.15 ;
          fDisk(x, 0.5*ytt+0.5*ybb, r, r*aspect, FILLED) ;


          fEnv("lineWidth", 1.0) ;
          fCurve("cos(x/2)" , 0, -pi, pi, OPEN) ;
          fCurve("0.35*(x*x-3.14159*3.14159)" , 0, -pi, pi, OPEN) ;






     }
}

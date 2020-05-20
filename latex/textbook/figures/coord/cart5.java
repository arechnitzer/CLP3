                  /*  File:  cart5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cart5 extends Template {

     static {templateClass = new cart5() ; }

     public void setup() {
          filePrefix = "cart5" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  
          xmin = -70 ;
          xmax =  80 ;
          ymin = -100 ;
          ymax =  50 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 30 ;
//          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double x = 30 ;
          double y = 30 ;
          double z = 30 ;



          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(y,0, x*x0+y,x*x1) ;
          fLine(x*x0,x*x1, x*x0+y,x*x1) ;
          fLine(y,z, x*x0+y,x*x1+z) ;
          fLine(0,z, x*x0,x*x1+z) ;
          fLine(x*x0,x*x1+z, x*x0+y,x*x1+z) ;
          fLine(x*x0+y,x*x1, x*x0+y,x*x1+z) ;
          fLine(y,0, y,z) ;
          fLine(0,z, y,z) ;
          fLine(x*x0,x*x1, x*x0,x*x1+z) ;
          fLine(x*x0,x*x1+z, x*x0+y,x*x1+z) ;

          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(0,0,  y,0) ;
          fLine(0,0,  0,z) ;
          fLine(0,0,  x*x0,x*x1) ;
//          fLine(0,0,0, xxmax*x1+ymax+12) ;
//          fLine(0,0, y+xxmax*x0, (y+xxmax*x0)*xxmax*x1/(xxmax*x0)) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fTeXlabel(x*x0/2+1+y,x*x1/2, "tl", "$\\dee{x}$") ;
          fTeXlabel(x*x0+y/2,x*x1-1, "tc", "$\\dee{y}$") ;
          fTeXlabel(y+2,z/2, "lc", "$\\dee{z}$") ;

          fTeXlabel(5,-27, "tc", "volume element $\\dee{V}=\\dee{x}\\,\\dee{y}\\,\\dee{z}$") ;

          
     }
}




                  /*  File:  hiddenD.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hiddenD extends Template {

     static {templateClass = new hiddenD() ; }

     public void setup() {
          filePrefix = "hiddenD" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 20*0.15 ;   
          ysize = 14*0.15 ;   
          xmin = -10  ;
          xmax = 10 ;
          ymin = -7 ;
          ymax = 7 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double r = 0.2 ;
          double OX = 5 ; double OY = 3 ;
          double IX = 2 ; double IY = 1 ;
          double SX = 1.0 ; double SY = 0.5 ;
          double x = -3 ; double y = OY*Math.sqrt(1-x*x/(OX*OX)) ;
          double vx = y/(OY*OY) ; double vy = -x/(OX*OX) ;
          double ex = x+30*vx ; double ey = y+30*vy ;
       
          double th = 20 ; double thRad = th*Math.PI/180 ;
          double phiRad = Math.atan(vy/vx) ; double phi = phiRad*180/Math.PI ;
          double vxu = vx*Math.cos(thRad) -vy*Math.sin(thRad) ;
          double vyu = vx*Math.sin(thRad) +vy*Math.cos(thRad) ;
          double vxl = vx*Math.cos(thRad) +vy*Math.sin(thRad) ;
          double vyl = -vx*Math.sin(thRad) +vy*Math.cos(thRad) ;
          double re = 1.0/(Math.sqrt(vx*vx+vy*vy)) ;
          double re2 = 0.75/(Math.sqrt(vx*vx+vy*vy)) ;


          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.6) ;
          fEnv("headLength", 6*1.5) ;
          fDisk(0,0, OX,OY, CLOSED+FILLED) ;
          fTeXlabel(0.6*OX, -0.8*OY-0.2, "tl", "$\\scriptstyle G(x,y,z)=0$") ;

//          fEnv("psFillGray", 1.0) ;
//          fDisk(SX,SY, IX,IY, CLOSED+FILLED) ;

          fEnv("psFillGray", 0.85) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fArrow(ex-1.3*re2*vx,ey-1.3*re2*vy, x,y) ;
          fTeXlabel(ex+0.2,ey, "cl", "$\\scriptstyle(x_e,y_e,z_e)$") ;
          fTeXlabel(ex-15*vx,ey-15*vy,"tl",
                        "$\\scriptstyle\\llt x-x_e,y-y_e,z-z_e \\rgt$") ;
//          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
          fLine(x, y, x-8*vx, y-8*vy ) ;
//          fTeXlabel(x-8*vx-0.4, y-8*vy+0.4, "bl", "$\\vv$") ;
          fArrow(x, y, x-8*vy, y+8*vx ) ;
          fTeXlabel(x-8*vy, y+8*vx+0.2, "bc", "$\\scriptstyle\\vnabla G(x,y,z)$") ;
//          fTeXlabel(x-8*vy, y+8*vx+0.2, "bc", "$\\vn$") ;
//          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fDisk(x,y, r,r, CLOSED+FILLED) ;
          fTeXlabel(x-0.4, y-0.4, "tl", "$\\scriptstyle(x,y,z)$") ;


          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(ex,ey, 0.75, 0.75, 180+phi-th, 180+phi+th, FILLED+WEDGE) ;
          fLine(ex,ey, ex-re*vxu, ey-re*vyu) ;
          fLine(ex,ey, ex-re*vxl, ey-re*vyl) ;
          fEllipticalArc(ex,ey, 0.75, 0.75, 180+phi-th, 180+phi+th, OPEN) ;
     }
}

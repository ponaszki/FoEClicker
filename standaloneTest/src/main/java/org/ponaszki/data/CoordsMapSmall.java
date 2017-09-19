package org.ponaszki.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ponaszki on 2017-09-19.
 */
public class CoordsMapSmall implements CoordsMap {
    List<Coordinates> coordsMap;

    CoordsMapSmall(){
        coordsMap = new ArrayList<Coordinates>();
        coordsMap.add(new Coordinates(1350, 390));
        coordsMap.add(new Coordinates(1220, 450));
        coordsMap.add(new Coordinates(1090, 510));
        coordsMap.add(new Coordinates(960, 570));
        coordsMap.add(new Coordinates(470, 350));
    }

    public List<Coordinates> getCoordinates() {
        return coordsMap;
    }
}

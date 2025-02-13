/*
 * Iris is a World Generator for Minecraft Bukkit Servers
 * Copyright (c) 2022 Arcane Arts (Volmit Software)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.volmit.iris.util.io;

import com.volmit.iris.util.math.RNG;

import java.io.File;
import java.io.IOException;

public class InstanceState {
    public static int getInstanceId() {
        try {
            return Integer.parseInt(IO.readAll(instanceFile()).trim());
        } catch(Throwable e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static void updateInstanceId() {
        try {
            IO.writeAll(instanceFile(), RNG.r.imax() + "");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static File instanceFile() {
        File f = new File("plugins/Iris/cache/instance");
        f.getParentFile().mkdirs();
        return f;
    }
}

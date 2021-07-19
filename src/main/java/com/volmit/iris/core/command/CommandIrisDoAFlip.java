/*
 * Iris is a World Generator for Minecraft Bukkit Servers
 * Copyright (c) 2021 Arcane Arts (Volmit Software)
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

package com.volmit.iris.core.command;

import com.volmit.iris.Iris;
import com.volmit.iris.core.pregenerator.PregenTask;
import com.volmit.iris.core.tools.IrisToolbelt;
import com.volmit.iris.util.collection.KList;
import com.volmit.iris.util.exceptions.IrisException;
import com.volmit.iris.util.format.C;
import com.volmit.iris.util.math.Position2;
import com.volmit.iris.util.plugin.MortarCommand;
import com.volmit.iris.util.plugin.VolmitSender;
import com.volmit.iris.util.scheduling.J;

public class CommandIrisDoAFlip extends MortarCommand {
    public CommandIrisDoAFlip() {
        super("doabackflip");
        requiresPermission(Iris.perm.studio);
        setDescription("Create a headless pregenerated world");
        setCategory("Studio");
    }


    @Override
    public void addTabOptions(VolmitSender sender, String[] args, KList<String> list) {

    }

    @Override
    public boolean handle(VolmitSender sender, String[] args) {
        try {
            IrisToolbelt.createWorld()
                    .headless(true)
                    .name("thebackflip")
                    .dimension("overworld")
                    .seed(6969696969L)
                    .sender(sender)
                    .studio(false)
                    .pregen(PregenTask.builder()
                            .radius(2)
                            .center(new Position2(0, 0))
                            .build())
                    .create();
        } catch (IrisException e) {
            e.printStackTrace();
            sender.sendMessage("Check Console");
        }

        return true;
    }

    @Override
    protected String getArgsUsage() {
        return "<name> [-t/--trim]";
    }
}

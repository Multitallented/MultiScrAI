const serverStart = require('./helpers/serverStartup');
const _ = require('lodash');

describe("Screeps Server Tests", function() {
    let server = undefined;

    beforeEach(function () {
        const { ScreepsServer } = require('screeps-server-mockup');
        server = new ScreepsServer();
    });

    afterEach(function() {
        server.stop();
    });

    it("Empty upgrader should start harvesting", async function() {
        let structures = [
            { name: "Spawn1", stuctureType: "spawn", pos: { x: 25, y: 25 } }
        ];


        await serverStart.runServer(server, [ serverStart.terrainNormal ],
            {controllerLevel: 1, structures: structures, ticks: 1 }, null, async (world) => {

                let spawner = null;
                let roomObjects = await world.roomObjects('W0N1');
                _.forEach(roomObjects, (obj) => {
                    if (obj.type === 'structure' && obj.structureType === 'spawn') {
                        spawner = obj;
                    }
                });
                if (spawner == null) {
                    fail();
                }
                expect(spawner.spawning).not.toBe(null);
            });

    });

    it("Full upgrader should start upgrading", async function() {
        let creeps = [
            { name: "Upgrader1253", memory: { role: 'UPGRADER', action: { action: "HARVEST" } },
                carry: { energy: 300 }, carryCapacity: 300, pos: { x: 15, y: 40 } }
        ];

        let structures = [
            { name: "Spawn1", stuctureType: "spawn", pos: { x: 25, y: 25 } }
        ];


        await serverStart.runServer(server, [ serverStart.terrainNormal ],
            {controllerLevel: 1, structures: structures, creeps: creeps, ticks: 1 }, null, async (world) => {

                let spawner = null;
                let roomObjects = await world.roomObjects('W0N1');
                _.forEach(roomObjects, (obj) => {
                    if (obj.type === 'structure' && obj.structureType === 'spawn') {
                        spawner = obj;
                    }
                });
                if (spawner == null) {
                    fail();
                }
                expect(spawner.spawning).toBe(null);
            });
    });
});
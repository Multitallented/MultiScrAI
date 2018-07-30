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
        let creeps = [
            { name: "Upgrader124", memory: { role: 'UPGRADER', action: { action: "UPGRADE_CONTROLLER", targetId: "control"} }, carry: { energy: 0 }, carryCapacity: 300, pos: { x: 15, y: 40 } }
        ];

        let upgrader = null;
        let sourceId = null;

        await serverStart.runServer(server, [ serverStart.terrainNormal ],
            {controllerLevel: 1, creeps: creeps, ticks: 1 }, null, (world) => {
                _.forEach(world.roomObjects('W0N1'), (obj) => {
                    if (obj.type === 'source') {
                        console.log("source found");
                        sourceId = obj._id;
                    }
                    if (obj.memory && obj.memory.role === 'UPGRADER') {
                        console.log("upgrader found");
                        upgrader = obj;
                    }
                });
            });


        if (upgrader == null || sourceId == null) {
            fail();
        }
        expect(upgrader.memory.action.targetId).toBe(sourceId);
    });

    it("Full upgrader should start upgrading", async function() {
        let creeps = [
            { name: "Upgrader1253", memory: { role: 'UPGRADER', action: { action: "HARVEST" } }, carry: { energy: 300 }, carryCapacity: 300, pos: { x: 15, y: 40 } }
        ];

        let upgrader = null;
        let controllerId = null;

        await serverStart.runServer(server, [ serverStart.terrainNormal ],
            {controllerLevel: 1, creeps: creeps, ticks: 1 }, async (world) => {
                let roomObjects = await world.roomObjects('W0N1');
                _.forEach(roomObjects, null, (obj) => {
                    if (obj.type === 'controller') {
                        console.log("controller found");
                        controllerId = obj._id;
                    }
                    if (obj.memory && obj.memory.role === 'UPGRADER') {
                        console.log("upgrader found");
                        upgrader = obj;
                    }
                });
            });


        if (upgrader == null || controllerId == null) {
            fail();
        }
        expect(upgrader.memory.action.targetId).toBe(controllerId);
    });
});
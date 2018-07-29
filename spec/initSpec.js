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
            { memory: { role: 'upgrader' }, carry: { energy: 0 }, carryCapacity: 300, pos: { x: 15, y: 40 } }
        ];

        await serverStart.runServer(server, [ serverStart.terrainNormal ],
            {controllerLevel: 1, creeps: creeps, ticks: 1 });

        let upgrader = null;
        let sourceId = null;
        _.forEach(await server.world.roomObjects('W0N1'), (obj) => {
            if (obj.type === 'source') {
                sourceId = obj._id;
            }
            if (obj.memory && obj.memory.role === 'upgrader') {
                upgrader = obj;
            }
        });
        if (upgrader == null || sourceId == null) {
            fail();
        }
        expect(upgrader.memory.action.targetId).toBe(sourceId);
    });

    it("Full upgrader should start upgrading", async function() {
        let creeps = [
            { memory: { role: 'upgrader' }, carry: { energy: 300 }, carryCapacity: 300, pos: { x: 15, y: 40 } }
        ];

        await serverStart.runServer(server, [ serverStart.terrainNormal ],
            {controllerLevel: 1, creeps: creeps, ticks: 1 });

        let upgrader = null;
        let controllerId = null;
        _.forEach(await server.world.roomObjects('W0N1'), (obj) => {
            if (obj.type === 'controller') {
                controllerId = obj._id;
            }
            if (obj.memory && obj.memory.role === 'upgrader') {
                upgrader = obj;
            }
        });
        if (upgrader == null || controllerId == null) {
            fail();
        }
        expect(upgrader.memory.action.targetId).toBe(controllerId);
    });
});
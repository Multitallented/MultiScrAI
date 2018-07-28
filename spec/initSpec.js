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

    it("server should have room W0N1", async function() {
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
        expect(upgrader.memory.currentOrder.target).not.toBe(sourceId);
    });
});
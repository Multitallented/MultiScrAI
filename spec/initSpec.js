const serverStart = require('./helpers/serverStartup');

describe("Screeps Server Tests", function() {
    let server = undefined;

    beforeEach(async function () {
        const { ScreepsServer, TerrainMatrix } = require('screeps-server-mockup');
        server = new ScreepsServer();
        await serverStart.runServer(server, TerrainMatrix);
    });

    it("server should have room W0N1", function() {
        expect(server.world.roomObjects('W0N1')).not.toBe(undefined);
    });
});
from flask import Flask, jsonify, request

app = Flask(__name__)

notifications = [
    {
        "id": 1,
        "account_id": 101,
        "message": "Transaction completed successfully"
    }
]


@app.route("/")
def home():

    return jsonify({
        "service": "Notification Service",
        "status": "UP"
    })


@app.route("/health")
def health():

    return jsonify({
        "service": "Notification Service",
        "status": "healthy"
    })


@app.route("/notifications", methods=["GET"])
def get_notifications():

    return jsonify(notifications)


@app.route("/notifications", methods=["POST"])
def create_notification():

    data = request.get_json()

    notification = {
        "id": len(notifications) + 1,
        "account_id": data.get("account_id"),
        "message": data.get("message")
    }

    notifications.append(notification)

    return jsonify(notification), 201


if __name__ == "__main__":

    app.run(
        host="0.0.0.0",
        port=5000
    )

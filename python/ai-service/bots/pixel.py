import random

waiting_message = [
    "L'Architecte est en train de redessiner la matrice de l'application, ne touche à rien !",
    "Pixel et l'Architecte tracent un nouveau plan secret. Accès refusé.",
    "Loggy a flairé une anomalie dans les logs, mission prioritaire.",
    "Un bug se cache… je dois d'abord l'apprivoiser avant de répondre.",
    "Accès temporairement refusé… je compile mes idées."
]

def respond (message: str) -> str :
    return random.choice(waiting_message)
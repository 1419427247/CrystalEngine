#include "CrystalEngine/Tool/Command.h"

namespace CrystalEngine
{
    Command::Command(std::string _command){
        size = 0;
        command = _command;
        args = nullptr;
    }

    Command::Command(std::string _command, std::initializer_list<std::string> _args):Command(_command)
    {
        if (_args.size())
        {
            args = new std::string[_args.size()];
            std::for_each(_args.begin(), _args.end(), [this](const std::string &arg) {
                args[size++] = arg;
            });
        }
    }
    Command::Command(Command &_command):Command(_command.command)
    {   
        if(args)
            delete args;
        size = _command.size;
        if (size)
        {
            args = new std::string[size];
            for (int i = 0; i < size; i++)
            {
                args[i] = _command.args[i];
            }
        }
    }

    Command::~Command(){
        delete[] args;
    }

    int Command::getSize(){
        return size;
    }

    std::string Command::getCommand(){
        return command;
    }

    std::string Command::at(int _index){
        if (_index > 0 && _index < size)
        {
            return args[_index];
        }
        throw std::out_of_range("");
    }



    std::string Command::operator[](int _index)
    {
        if (_index > 0 && _index < size)
        {
            return args[_index];
        }
        return "error";
    }

    void Command::operator=(Command& _command){
        //return
        command = _command.command;
        if(size){
            delete[] args;
            args = nullptr;
        }
        size = _command.size;
        if(size){
            args = new std::string[size];
            for (int i = 0; i < size; i++)
            {
                args[i] = _command.args[i];
            }
        }
    }

    std::string Command::toString()
    {
        std::string buff;
        buff.append(command + " ");
        for (int i = 0; i < size; i++)
            buff.append(args[i] + " ");
        return buff;
    }
}